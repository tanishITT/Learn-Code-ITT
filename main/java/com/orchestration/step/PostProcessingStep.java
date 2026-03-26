package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class PostProcessingStep implements WorkflowStep {

    private static final String STEP_NAME = "PostProcessingStep";
    private static final String MULTIPLE_WHITESPACE_PATTERN = "\\s+";
    private static final String SINGLE_SPACE = " ";

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        String processed = "[Post-Processed]: "
            + input.trim().replaceAll(MULTIPLE_WHITESPACE_PATTERN, SINGLE_SPACE);
        return StepExecutionResult.success(processed);
    }

    @Override
    public String getStepName() {
        return STEP_NAME;
    }
}
