package com.orchestration.condition;

import com.orchestration.core.StepCondition;

public class InputLengthExceedsCondition implements StepCondition {

    private final int minimumLength;
    public InputLengthExceedsCondition(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    @Override
    public boolean isSatisfiedBy(String input) {
        return input != null && input.length() > minimumLength;
    }

    @Override
    public String describe() {
        return "InputLengthExceeds(" + minimumLength + ")";
    }
}
