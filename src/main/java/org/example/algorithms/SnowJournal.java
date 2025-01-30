package org.example.algorithms;

import java.util.List;

/**
 * This class provides a solution to the snow measurement problem.
 * <p>
 * Task:
 * - You are given a log of snow measurements over `n` days.
 * - Some measurements are missing or corrupted:
 * - `-1` indicates an unreadable value (missing data).
 * - Any value greater than 10^9 is considered invalid.
 * - Snowfall is positive every day, and measurements must form a consistent sequence.
 * <p>
 * Objective:
 * - Determine if it is possible to restore the missing measurements such that
 * they agree with the log's constraints.
 * - If restoration is impossible, return "NO". Otherwise, return "YES" and the restored sequence.
 * <p>
 * Approach:
 * - Validate the input for invalid values.
 * - Replace `-1` values with suitable numbers such that:
 * 1. The sequence remains consistent.
 * 2. Positive snowfall is maintained.
 * - If restoration fails, return "NO".
 */
public class SnowJournal {
    private static final String NO = "NO";

    /**
     * Restores the sequence of snowfall measurements.
     *
     * @param measurements A list of integers representing snowfall measurements.
     * @return A result string:
     * - "NO" if restoration is impossible.
     * - "YES" followed by the restored sequence if restoration succeeds.
     */
    public static String restoreMeasurements(List<Integer> measurements) {
        int n = measurements.size();
        int[] result = new int[n];

        // Attempt to restore the sequence
        for (int i = 0; i < n; i++) {
            if (notValidValue(measurements.get(i))) {
                return NO;
            }
            if (measurements.get(i) != -1) {
                result[i] = measurements.get(i);
            } else {
                // Find a valid value for result[i]
                int previous = i > 0 ? result[i - 1] : 0; // Previous day's value
                int next = (i < n - 1 && measurements.get(i + 1) != -1) ? measurements.get(i + 1) : Integer.MAX_VALUE;

                // Assign the minimum valid value that keeps the sequence consistent
                result[i] = previous + 1;

                // If the value conflicts with the next day's measurement, restoration fails
                if (result[i] >= next) {
                    return NO;
                }
            }

            if (i != 0 && result[i] < result[i - 1]) {
                return NO;
            }
        }
        return getFormattedResult(result);
    }

    // Validate input
    private static boolean notValidValue(int value) {
        return value > 1_000_000_000;
    }

    // Build the result
    private static String getFormattedResult(int[] result) {
        StringBuilder output = new StringBuilder("YES\n");
        for (int value : result) {
            output.append(value).append(" ");
        }
        return output.toString().trim();
    }

}

