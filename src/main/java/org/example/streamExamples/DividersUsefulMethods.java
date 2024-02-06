package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DividersUsefulMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        maxNumberDivider(a, b);
        scanner.close();
    }

    private static void maxNumberDivider(int a, int b) {
        int numberWithMaxDividers = getNumberWithMaxDividers(a, b);
        System.out.println(IntStream.rangeClosed(a, b)
                .filter(n -> getDividersNumber(n) == numberWithMaxDividers)
                .findFirst().orElseThrow());
    }

    private static int getNumberWithMaxDividers(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .map(DividersUsefulMethods::getDividersNumber)
                .max()
                .orElse(0);
    }

    private static int getDividersNumber(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(value -> n % value == 0)
                .count();
    }
}
