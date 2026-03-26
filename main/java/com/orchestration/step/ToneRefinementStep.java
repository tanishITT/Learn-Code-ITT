package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class ToneRefinementStep implements WorkflowStep {

    private static final String STEP_NAME = "ToneRefinementStep";

    private final String targetTone;
    public ToneRefinementStep(String targetTone) {
        this.targetTone = targetTone;
    }

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        String refined = "[Tone=" + targetTone + "]: " + input;
        return StepExecutionResult.success(refined);
    }

    @Override
    public String getStepName() {
        return STEP_NAME + "(" + targetTone + ")";
    }
}
