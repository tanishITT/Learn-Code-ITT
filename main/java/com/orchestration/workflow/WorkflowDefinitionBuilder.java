package com.orchestration.workflow;

import com.orchestration.core.WorkflowStep;

import java.util.ArrayList;
import java.util.List;
public class WorkflowDefinitionBuilder {

    private String workflowName;
    private final List<WorkflowStep> steps = new ArrayList<>();
    public WorkflowDefinitionBuilder withName(String workflowName) {
        this.workflowName = workflowName;
        return this;
    }
    public WorkflowDefinitionBuilder addStep(WorkflowStep step) {
        steps.add(step);
        return this;
    }

    public WorkflowDefinition build() {
        if (workflowName == null || workflowName.isBlank()) {
            throw new IllegalStateException("A workflow must have a non-blank name.");
        }
        if (steps.isEmpty()) {
            throw new IllegalStateException("A workflow must contain at least one step.");
        }
        return new WorkflowDefinition(workflowName, steps);
    }
}
