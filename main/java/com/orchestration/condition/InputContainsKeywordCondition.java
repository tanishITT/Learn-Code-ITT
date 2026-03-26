package com.orchestration.condition;

import com.orchestration.core.StepCondition;

public class InputContainsKeywordCondition implements StepCondition {

    private final String keyword;
    public InputContainsKeywordCondition(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean isSatisfiedBy(String input) {
        return input != null && input.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String describe() {
        return "InputContainsKeyword(\"" + keyword + "\")";
    }
}
