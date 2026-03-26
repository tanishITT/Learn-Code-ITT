package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class ContextEnrichmentStep implements WorkflowStep {

    private static final String STEP_NAME = "ContextEnrichmentStep";

    private final String contextSource;
    public ContextEnrichmentStep(String contextSource) {
        this.contextSource = contextSource;
    }

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        String enriched = "[Enriched via " + contextSource + "]: " + input;
        return StepExecutionResult.success(enriched);
    }

    @Override
    public String getStepName() {
        return STEP_NAME + "(" + contextSource + ")";
    }
}
