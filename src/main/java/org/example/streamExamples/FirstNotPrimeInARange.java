package org.example.streamExamples;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input 1:
8 22
Sample Output 1:
8

Sample Input 2:
22 8
Sample Output 2:
8

Sample Input 3:
1 3
Sample Output 3:
NO
*/
public class FirstNotPrimeInARange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        IntStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                .filter(n -> {
                    if (n == 1) return false;
                    BigInteger integer = BigInteger.valueOf(n);
                    return !integer.isProbablePrime(10);
                }).findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("NO"));

        scanner.close();
    }
}
