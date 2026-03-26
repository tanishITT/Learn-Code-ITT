package com.orchestration.decorator;

import com.orchestration.core.StepExecutionResult;
import com.orchestration.core.WorkflowStep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RetryableWorkflowStep implements WorkflowStep {

    private static final Logger LOGGER = Logger.getLogger(RetryableWorkflowStep.class.getName());

    private final WorkflowStep delegate;
    private final int maximumAttempts;

    public RetryableWorkflowStep(WorkflowStep delegate, int maximumAttempts) {
        if (maximumAttempts < 1) {
            throw new IllegalArgumentException(
                "maximumAttempts must be at least 1, but was: " + maximumAttempts
            );
        }
        this.delegate = delegate;
        this.maximumAttempts = maximumAttempts;
    }

    @Override
    public StepExecutionResult execute(String input) {
        StepExecutionResult lastResult = StepExecutionResult.failure("No attempts were made.");

        for (int attempt = 1; attempt <= maximumAttempts; attempt++) {
            lastResult = delegate.execute(input);

            if (lastResult.isSuccessful()) {
                return lastResult;
            }

            LOGGER.log(Level.WARNING,
                "Attempt {0}/{1} failed for step [{2}]: {3}",
                new Object[]{attempt, maximumAttempts, delegate.getStepName(), lastResult.getErrorMessage()}
            );
        }

        return StepExecutionResult.failure(
            "Step [" + delegate.getStepName() + "] failed after " + maximumAttempts +
            " attempt(s). Last error: " + lastResult.getErrorMessage()
        );
    }

    @Override
    public String getStepName() {
        return "Retryable(" + delegate.getStepName() + ", maxAttempts=" + maximumAttempts + ")";
    }
}
