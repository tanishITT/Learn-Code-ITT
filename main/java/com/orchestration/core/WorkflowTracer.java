package com.orchestration.core;
public interface WorkflowTracer {
    void traceStepStarted(String workflowName, String stepName, String input);
    void traceStepSucceeded(String workflowName, String stepName, String output);
    void traceStepFailed(String workflowName, String stepName, String errorMessage);
    void traceWorkflowCompleted(String workflowName, String finalOutput);
    void traceWorkflowFailed(String workflowName, String reason);
}
