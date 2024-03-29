package org.example.streamExamples;

import org.example.Main;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input 1:
1 12
Sample Output 1:
2 3 5 7 11

Sample Input 2:
20 22
Sample Output
*/
public class IsProbablePrimeExampleRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStream.rangeClosed(scanner.nextInt(), scanner.nextInt())
                .filter(n -> {
                    BigInteger integer = BigInteger.valueOf(n);
                    return integer.isProbablePrime(10);
                })
                .forEach(n -> System.out.print(n + " "));

        scanner.close();
    }

    private static int simpleInRange(int a, int b) {
        return (int) IntStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                .filter(IsProbablePrimeExampleRange::isSimple).count();
    }

    private static boolean isSimple(int n) {
        return n >= 2 && BigInteger.valueOf(n).isProbablePrime(10);
    }
}
