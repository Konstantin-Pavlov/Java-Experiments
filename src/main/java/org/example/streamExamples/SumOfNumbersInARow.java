package org.example.streamExamples;

import java.util.Arrays;
import java.util.Scanner;

/*8 11 -> 19*/
public class SumOfNumbersInARow {
    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .sum());
    }
}
