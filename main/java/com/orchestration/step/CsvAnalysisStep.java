package com.orchestration.step;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

public class CsvAnalysisStep implements WorkflowStep {

    private static final String STEP_NAME = "CsvAnalysisStep";
    private static final String CSV_FIELD_DELIMITER = ",";

    @Override
    public StepExecutionResult execute(String input) {
        if (input == null || input.isBlank()) {
            return StepExecutionResult.failure(
                "Input to " + STEP_NAME + " must not be blank."
            );
        }
        int fieldCount = input.split(CSV_FIELD_DELIMITER).length;
        String analysis = "[CSV Analysis]: Detected " + fieldCount + " fields. Raw header: " + input;
        return StepExecutionResult.success(analysis);
    }

    @Override
    public String getStepName() {
        return STEP_NAME;
    }
}
