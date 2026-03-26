package com.orchestration.core;
public class StepExecutionResult {

    private final boolean successful;
    private final String output;
    private final String errorMessage;

    private StepExecutionResult(boolean successful, String output, String errorMessage) {
        this.successful = successful;
        this.output = output;
        this.errorMessage = errorMessage;
    }
    public static StepExecutionResult success(String output) {
        return new StepExecutionResult(true, output, null);
    }
    public static StepExecutionResult failure(String errorMessage) {
        return new StepExecutionResult(false, null, errorMessage);
    }

    public boolean isSuccessful() {
        return successful;
    }
    public String getOutput() {
        return output;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
