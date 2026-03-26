package com.orchestration.core;
public interface WorkflowStep {
    StepExecutionResult execute(String input);
    String getStepName();
}
