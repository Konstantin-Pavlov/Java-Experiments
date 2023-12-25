package org.example.algorithms;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711
        for (int n = 0; n < 15; n++) {
            long[] fibs = new long[n + 1];
            Arrays.fill(fibs, -1);
            System.out.printf("%2d: ", n);
            System.out.printf("%4d ", recWithMemoization(n, fibs));
            System.out.printf("%4d ", effective(n));
            System.out.printf("%4d%n", justRecursion(n));
        }

    }

    // with results saving
    public static long recWithMemoization(int n, long[] fibs) {
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
    public static long justRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return justRecursion(n - 1) + justRecursion(n - 2);
    }

    public static long effective(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

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
