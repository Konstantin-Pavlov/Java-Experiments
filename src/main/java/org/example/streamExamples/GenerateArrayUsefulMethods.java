package org.example.streamExamples;

import org.example.Main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateArrayUsefulMethods {
    final static int LOWER_LIMIT = -5;
    final static int UPPER_LIMIT = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.close();
    }

    private static void init1DArray(int[] nums, int seed) {
        System.arraycopy(
                new Random(seed).ints(LOWER_LIMIT, UPPER_LIMIT)
                        .limit(nums.length)
                        .toArray(),
                0,
                nums,
                0,
                nums.length
        );
    }

    private static void init2DArray(int[][] nums, long seed) {
        Random random = new Random(seed);
        System.arraycopy(
                IntStream
                        .rangeClosed(0, nums.length)
                        .mapToObj(row -> random.ints(nums[0].length, LOWER_LIMIT, UPPER_LIMIT).toArray())
                        .toArray(int[][]::new),
                0,
                nums,
                0,
                nums.length
        );
    }

    private static int getIndexOfMaxValue(int[] mas) {
        int maxElement = Arrays.stream(mas).max().orElse(Integer.MIN_VALUE);
        return IntStream.range(0, mas.length).filter(index -> mas[index] == maxElement).findFirst().orElse(-1);
    }

    private static void printMaxIndex(int[][] nums) {
        Arrays.stream(nums).forEach(row -> {
            System.out.print(getIndexOfMaxValue(row) + " ");
        });
        System.out.println();

    }

    private static int[][] deleteRow(int[][] array, int rowIndexToDelete) {
        if (rowIndexToDelete < 0 || rowIndexToDelete >= array.length) {
            return array;
        }
        // another way without stream
//        int[][] result = new int[array.length - 1][];
//        System.arraycopy(array, 0, result, 0, rowIndexToDelete);
//        System.arraycopy(array, rowIndexToDelete + 1, result, rowIndexToDelete, array.length - rowIndexToDelete - 1);
//        return result;

        return Stream
                .concat(Arrays.stream(
                                Arrays.copyOfRange(array, 0, rowIndexToDelete)),
                        Arrays.stream(array, rowIndexToDelete + 1, array.length))
                .toArray(int[][]::new);
    }

    private static int[][] deleteRowShortened(int[][] array, int rowIndexToDelete) {
        return rowIndexToDelete < 0 || rowIndexToDelete >= array.length ?
                array :
                Stream.concat(
                                Arrays.stream(Arrays.copyOfRange(array, 0, rowIndexToDelete)),
                                Arrays.stream(Arrays.copyOfRange(array, rowIndexToDelete + 1, array.length))
                        )
                        .toArray(int[][]::new);
    }

    private static void print1DArray(int[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    private static void print2DArray(int[][] mas) {
        Arrays.stream(mas).forEach(GenerateArrayUsefulMethods::print1DArray);
    }

    private static void print(double[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.printf("%.2f ", num));
        System.out.println();
    }
}
