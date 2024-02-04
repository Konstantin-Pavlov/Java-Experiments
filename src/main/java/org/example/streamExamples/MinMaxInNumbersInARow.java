package org.example.streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Sample Input:
6000 12000 10500
Sample Output:
6000
*/

public class MinMaxInNumbersInARow {
    public static void main(String[] args) {
        List<Integer> nums = Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        System.out.println(nums.stream().max(Integer::compareTo).orElse(-1)
                - nums.stream().min(Integer::compareTo).orElse(-1));
    }
}
