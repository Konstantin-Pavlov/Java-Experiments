package org.example.algorithms;

import java.math.BigInteger;

public class CompositeNumbersWithPrimeDivisors {
    public static int countCompositeNumbersWithPrimeDivisors(int L, int R) {
        int count = 0;
        for (int num = L; num <= R; num++) {
            if (isComposite(num)) {
                int divisors = countDivisors(num);
                if (isPrime(divisors)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        return num > 1 && BigInteger.valueOf(num).isProbablePrime(10);
    }

    private static boolean isComposite(int num) {
        return num > 1 && !isPrime(num);
    }

    private static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i * i == n) { // Квадрат числа (например, 16 = 4 * 4)
                    count++;
                } else {
                    count += 2; // Две пары делителей
                }
            }
        }
        return count;
    }

}
