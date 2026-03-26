package com.orchestration.decorator;

import com.orchestration.core.StepCondition;
import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConditionalWorkflowStep implements WorkflowStep {

    private static final Logger LOGGER = Logger.getLogger(ConditionalWorkflowStep.class.getName());

    private final WorkflowStep delegate;
    private final StepCondition condition;

    public ConditionalWorkflowStep(WorkflowStep delegate, StepCondition condition) {
        this.delegate = delegate;
        this.condition = condition;
    }

    @Override
    public StepExecutionResult execute(String input) {
        if (!condition.isSatisfiedBy(input)) {
            LOGGER.log(Level.INFO,
                "Condition [{0}] not satisfied for step [{1}]. Step skipped; input passed through.",
                new Object[]{condition.describe(), delegate.getStepName()}
            );
            return StepExecutionResult.success(input);
        }
        return delegate.execute(input);
    }

    @Override
    public String getStepName() {
        return "Conditional(" + delegate.getStepName() + ", when=" + condition.describe() + ")";
    }
}
