package org.example.streamExamples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomIntsArraysSortIndexAIndexB {
    final static int LOWER_LIMIT = 10;
    final static int UPPER_LIMIT = 21;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();

        int indexA = scanner.nextInt();
        int indexB = scanner.nextInt();

        Random random = new Random(seed);

        int[] nums = random.ints(n, LOWER_LIMIT, UPPER_LIMIT).toArray();

        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums, indexA, indexB);
        System.out.println(Arrays.toString(nums));

        scanner.close();
    }
}
