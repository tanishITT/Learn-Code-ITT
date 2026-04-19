package com.solution;

import com.solution.domain.ConsecutiveDivisorPairFinder;
import com.solution.io.TestCaseReader;
import com.solution.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> upperBounds = TestCaseReader
                .parseTestCases(scanner);

        final List<Integer> results = new ArrayList<>(upperBounds.size());

        for (final int upperBound : upperBounds) {
            results.add(ConsecutiveDivisorPairFinder
                    .countMatchingPairs(upperBound));
        }

        OutputWriter.printResults(results, System.out);

        scanner.close();
    }
}
