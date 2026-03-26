package com.orchestration.workflow;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;
import com.orchestration.core.WorkflowTracer;

public class WorkflowOrchestrator {

    private final WorkflowTracer tracer;
    public WorkflowOrchestrator(WorkflowTracer tracer) {
        this.tracer = tracer;
    }
    public WorkflowExecutionResult execute(WorkflowDefinition workflowDefinition, String initialInput) {
        String currentOutput = initialInput;

        for (WorkflowStep step : workflowDefinition.getSteps()) {
            tracer.traceStepStarted(workflowDefinition.getWorkflowName(), step.getStepName(), currentOutput);

            StepExecutionResult stepResult = step.execute(currentOutput);

            if (stepResult.isSuccessful()) {
                currentOutput = stepResult.getOutput();
                tracer.traceStepSucceeded(workflowDefinition.getWorkflowName(), step.getStepName(), currentOutput);
            } else {
                tracer.traceStepFailed(
                    workflowDefinition.getWorkflowName(),
                    step.getStepName(),
                    stepResult.getErrorMessage()
                );
                tracer.traceWorkflowFailed(
                    workflowDefinition.getWorkflowName(),
                    stepResult.getErrorMessage()
                );
                return WorkflowExecutionResult.failure(
                    "Workflow [" + workflowDefinition.getWorkflowName() +
                    "] halted at step [" + step.getStepName() + "]: " +
                    stepResult.getErrorMessage()
                );
            }
        }

        tracer.traceWorkflowCompleted(workflowDefinition.getWorkflowName(), currentOutput);
        return WorkflowExecutionResult.success(currentOutput);
    }
}
