package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class SummarizationStep implements WorkflowStep {

    private static final String STEP_NAME = "SummarizationStep";
    private static final int PREVIEW_CHARACTER_LIMIT = 80;

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        int previewLength = Math.min(input.length(), PREVIEW_CHARACTER_LIMIT);
        String summary = "[Summary]: " + input.substring(0, previewLength) + "...";
        return StepExecutionResult.success(summary);
    }

    @Override
    public String getStepName() {
        return STEP_NAME;
    }
}
