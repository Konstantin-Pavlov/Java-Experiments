package org.example.streamExamples;

import org.example.Main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*Пользователь вводит количество строк и столбцов двумерного массива, а затем начальное значение генератора случайных чисел.
Создать массив целых чисел указанной размерности и инициализировать его случайными числами от -10 до 10.
Массив вывести на консоль в виде таблицы, элементы которой отделяются знаками табуляции. Знак табуляции должен быть и в конце каждой строки.

Вывести пустую строку после двумерного массива.

Для каждого столбца найти сумму положительных элементов и вывести на консоль, отделяя пробелами.

Sample Input:
4 5 89
Sample Output:
-3	-9	8	-6	2
9	1	-4	-4	-5
-10	5	-6	3	-3
-2	7	-4	1	-4

9 13 8 4 2

*/
public class Generate2DArrayFindColumnsSums {
    final static int LOWER_LIMIT = -10;
    final static int UPPER_LIMIT = 11;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int i = scanner.nextInt();
        final int j = scanner.nextInt();
        int seed = scanner.nextInt();

        Random random = new Random(seed);

        int[][] nums = IntStream
                .rangeClosed(0, i)
                .mapToObj(row -> random.ints(j, LOWER_LIMIT, UPPER_LIMIT).toArray())
                .toArray(int[][]::new);

        Arrays.stream(nums).forEach(Generate2DArrayFindColumnsSums::printArray);

        AtomicInteger columnSum = new AtomicInteger(0);

        Arrays.stream(nums).forEach(row -> {
            System.out.println(Arrays.stream(row).sum());
        });

        IntStream.range(0, j).forEach(col -> {
            IntStream.range(0, i).forEach(row -> {
                if (nums[row][col] > 0) columnSum.addAndGet(nums[row][col]);
            });
            System.out.println("Sum of column " + col + ": " + columnSum);
            columnSum.set(0); // Reset sum for the next column
        });


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
