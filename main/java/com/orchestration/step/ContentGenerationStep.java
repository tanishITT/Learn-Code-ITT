package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class ContentGenerationStep implements WorkflowStep {

    private static final String STEP_NAME = "ContentGenerationStep";

    private final String modelIdentifier;

    public ContentGenerationStep(String modelIdentifier) {
        this.modelIdentifier = modelIdentifier;
    }

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        String generatedContent = "[" + modelIdentifier + " Generated]: " + input;
        return StepExecutionResult.success(generatedContent);
    }

    @Override
    public String getStepName() {
        return STEP_NAME + "(" + modelIdentifier + ")";
    }
}
