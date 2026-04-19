package com.solution.domain;

public final class ConsecutiveDivisorPairFinder {

    private static final int MINIMUM_UPPER_BOUND = 3;

    private ConsecutiveDivisorPairFinder() {
    }

    public static int countMatchingPairs(final int upperBound) {
        if (upperBound < MINIMUM_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    "Upper bound must be at least 3 for a non-empty range, but was: " + upperBound);
        }

        int matchingPairCount = 0;
        int currentDivisorCount = DivisorCounter.countDivisors(2);

        for (int number = 2; number < upperBound; number++) {
            final int nextDivisorCount = DivisorCounter
                    .countDivisors(number + 1);

            if (currentDivisorCount == nextDivisorCount) {
                matchingPairCount++;
            }

            currentDivisorCount = nextDivisorCount;
        }

        return matchingPairCount;
    }
}
