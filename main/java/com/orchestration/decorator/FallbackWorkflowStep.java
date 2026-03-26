package com.orchestration.decorator;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FallbackWorkflowStep implements WorkflowStep {

    private static final Logger LOGGER = Logger.getLogger(FallbackWorkflowStep.class.getName());

    private final WorkflowStep primaryStep;
    private final WorkflowStep fallbackStep;

    public FallbackWorkflowStep(WorkflowStep primaryStep, WorkflowStep fallbackStep) {
        this.primaryStep = primaryStep;
        this.fallbackStep = fallbackStep;
    }

    @Override
    public StepExecutionResult execute(String input) {
        StepExecutionResult primaryResult = primaryStep.execute(input);

        if (primaryResult.isSuccessful()) {
            return primaryResult;
        }

        LOGGER.log(Level.WARNING,
            "Primary step [{0}] failed with error: {1}. Activating fallback step [{2}].",
            new Object[]{primaryStep.getStepName(), primaryResult.getErrorMessage(), fallbackStep.getStepName()}
        );

        return fallbackStep.execute(input);
    }

    @Override
    public String getStepName() {
        return "Fallback(primary=" + primaryStep.getStepName()
            + ", fallback=" + fallbackStep.getStepName() + ")";
    }
}
