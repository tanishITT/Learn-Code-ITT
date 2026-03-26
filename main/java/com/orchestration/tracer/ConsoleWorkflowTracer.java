package com.orchestration.tracer;

import com.orchestration.core.WorkflowTracer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleWorkflowTracer implements WorkflowTracer {

    private static final Logger LOGGER = Logger.getLogger(ConsoleWorkflowTracer.class.getName());

    @Override
    public void traceStepStarted(String workflowName, String stepName, String input) {
        LOGGER.log(Level.INFO,
            "[TRACE] Workflow={0} | Step={1} | START    | Input={2}",
            new Object[]{workflowName, stepName, input}
        );
    }

    @Override
    public void traceStepSucceeded(String workflowName, String stepName, String output) {
        LOGGER.log(Level.INFO,
            "[TRACE] Workflow={0} | Step={1} | SUCCESS  | Output={2}",
            new Object[]{workflowName, stepName, output}
        );
    }

    @Override
    public void traceStepFailed(String workflowName, String stepName, String errorMessage) {
        LOGGER.log(Level.WARNING,
            "[TRACE] Workflow={0} | Step={1} | FAILED   | Error={2}",
            new Object[]{workflowName, stepName, errorMessage}
        );
    }

    @Override
    public void traceWorkflowCompleted(String workflowName, String finalOutput) {
        LOGGER.log(Level.INFO,
            "[TRACE] Workflow={0} | COMPLETED | FinalOutput={1}",
            new Object[]{workflowName, finalOutput}
        );
    }

    @Override
    public void traceWorkflowFailed(String workflowName, String reason) {
        LOGGER.log(Level.SEVERE,
            "[TRACE] Workflow={0} | FAILED    | Reason={1}",
            new Object[]{workflowName, reason}
        );
    }
}
