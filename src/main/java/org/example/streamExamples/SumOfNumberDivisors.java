package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfNumberDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(
                IntStream.rangeClosed(1, n)
                        .filter(number -> n % number == 0)
                        .sum()
        );
        scanner.close();
    }
}

