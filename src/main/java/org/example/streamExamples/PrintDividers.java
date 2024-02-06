package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintDividers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printDivider(number);
    }


    private static void printDivider(int n) {
        IntStream.rangeClosed(1, n)
                .filter(value -> n % value == 0)
                .forEach(value -> System.out.print(value + " "));
    }
}
