package com.orchestration.workflow;

import com.orchestration.core.WorkflowStep;

import java.util.List;

public class WorkflowDefinition {

    private final String workflowName;
    private final List<WorkflowStep> steps;
    public WorkflowDefinition(String workflowName, List<WorkflowStep> steps) {
        this.workflowName = workflowName;
        this.steps = List.copyOf(steps);
    }

    public String getWorkflowName() {
        return workflowName;
    }
    public List<WorkflowStep> getSteps() {
        return steps;
    }
}
