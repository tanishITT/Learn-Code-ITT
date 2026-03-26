package com.orchestration.workflow;

import java.util.Optional;

public class WorkflowExecutionResult {

    private final boolean successful;
    private final String finalOutput;
    private final String failureReason;

    private WorkflowExecutionResult(boolean successful, String finalOutput, String failureReason) {
        this.successful = successful;
        this.finalOutput = finalOutput;
        this.failureReason = failureReason;
    }
    public static WorkflowExecutionResult success(String finalOutput) {
        return new WorkflowExecutionResult(true, finalOutput, null);
    }
    public static WorkflowExecutionResult failure(String failureReason) {
        return new WorkflowExecutionResult(false, null, failureReason);
    }

    public boolean isSuccessful() {
        return successful;
    }
    public Optional<String> getFinalOutput() {
        return Optional.ofNullable(finalOutput);
    }
    public Optional<String> getFailureReason() {
        return Optional.ofNullable(failureReason);
    }
}
