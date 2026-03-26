package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class TranslationStep implements WorkflowStep {

    private static final String STEP_NAME = "TranslationStep";

    private final String targetLanguage;
    public TranslationStep(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        String translated = "[Translated to " + targetLanguage + "]: " + input;
        return StepExecutionResult.success(translated);
    }

    @Override
    public String getStepName() {
        return STEP_NAME + "(" + targetLanguage + ")";
    }
}
