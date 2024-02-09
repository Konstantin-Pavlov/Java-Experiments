package org.example.streamExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FindTheLongestWordRemoveExtraSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Arrays.stream(scanner.nextLine().split(" +"))
                        .max(Comparator.comparing(String::length))
                        .orElse("ERROR")
        );
        scanner.close();
    }

}
