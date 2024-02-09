package org.example.streamExamples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Generate2DArrayFindMaxAndOccurrences {
    final static int LOWER_LIMIT = -5;
    final static int UPPER_LIMIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int seed = scanner.nextInt();

        Random random = new Random(seed);

        int[][] nums = IntStream
                .rangeClosed(0, i)
                .mapToObj(row -> random.ints(j, LOWER_LIMIT, UPPER_LIMIT).toArray())
                .toArray(int[][]::new);

        // Flatten the 2D array into a stream of integers
        int maxElement = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(Integer.MIN_VALUE);

        long maxElementOccurrences = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .filter(num -> num == maxElement)
                .count();

        Arrays.stream(nums).forEach(Generate2DArrayFindMaxAndOccurrences::printArray);
        System.out.println(maxElement + " " + maxElementOccurrences);
        scanner.close();
    }

    private static void printArray(double[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.printf("%.2f ", num));
        System.out.println();
    }

    private static void printArray(int[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
