package com.solution.io;

import java.io.PrintStream;
import java.util.List;

public final class OutputWriter {

    private OutputWriter() {
    }

    public static void printResults(final List<Integer> results,
                                    final PrintStream output) {
        for (final int result : results) {
            output.println(result);
        }
    }
}
