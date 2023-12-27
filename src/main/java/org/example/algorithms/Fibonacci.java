package org.example.algorithms;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711
        for (int n = 0; n < 76; n++) {
            long[] fibs = new long[n + 1];
            Arrays.fill(fibs, -1);
            System.out.printf("%2d: ", n);
            System.out.printf("%4d ", recWithMemoization(n, fibs));
            System.out.printf("%4d%n", effective(n));
//            System.out.printf("%4d%n", justRecursion(n)); // starting from N = 48 this algorithm starts to work very slowly
        }

    }

    /**
     * The time complexity of the provided method recWithMemoization is significantly improved compared to a naive recursive Fibonacci implementation without memoization.
     * The memoization ensures that each Fibonacci number is computed only once and then stored for reuse.
     * <p>
     * Let's analyze the time complexity:
     * <p>
     * The method processes each Fibonacci number from 0 to n exactly once.
     * For each Fibonacci number k, the computation involves adding the results of two previous Fibonacci numbers: recWithMemoization(k - 1, fibs) and recWithMemoization(k - 2, fibs).
     * Since each Fibonacci number is computed only once and subsequent computations are retrieved from the memoization array,
     * the time complexity of this method is O(n). It's a linear time complexity,
     * which is a significant improvement over the exponential time complexity of the naive recursive Fibonacci algorithm without memoization (O(2^n)).
     * <p>
     * The use of memoization allows the algorithm to avoid redundant calculations and ensures that the time complexity grows linearly with the input size.
     * Therefore, it's considered an efficient approach for computing Fibonacci numbers.
     */
    // with results saving
    public static long recWithMemoization(int n, long[] fibs) {
        // O(n)
        if (fibs[n] != -1) {
            return fibs[n];
        }
        if (n <= 1) {
            return n;
        }
        long result = recWithMemoization(n - 1, fibs) + recWithMemoization(n - 2, fibs);
        fibs[n] = result;
        return result;
    }

    // very inefficient algorithm. finding the 100th number will take many thousands of years
    // O(2^n)
    public static long justRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return justRecursion(n - 1) + justRecursion(n - 2);
    }

    // very fast algorithm
    public static long effective(int n) {
        // if we use array to store values, it adds O(n) complexity
        // long[] fibs = new long[n + 1];
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        // O(n); if using array -> O(n + n) = O(2n) = O(n)
        long a = 0;
        long b = 1;
        long sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }

}
