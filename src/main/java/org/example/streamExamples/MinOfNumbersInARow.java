package org.example.streamExamples;

import java.util.Arrays;
import java.util.Scanner;

public class MinOfNumbersInARow {
    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .min().orElse(Integer.MIN_VALUE));
    }
}
