package com.orchestration.core;

public interface StepCondition {

    boolean isSatisfiedBy(String input);
    String describe();
}
