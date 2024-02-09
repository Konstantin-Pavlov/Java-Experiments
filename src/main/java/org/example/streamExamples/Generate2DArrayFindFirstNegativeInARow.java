package org.example.streamExamples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Пользователь вводит количество строк и столбцов двумерного массива, а затем начальное значение генератора случайных чисел.
Создать массив целых чисел указанной размерности и инициализировать его случайными числами от -10 до 10.
Массив вывести на консоль в виде таблицы, элементы которой отделяются знаками табуляции. Знак табуляции должен быть и  в конце каждой строки.

В каждой строке найти первый отрицательный элемент и вывести индекс соответствующего столбца или слово "NO", если он отсутствует.

Sample Input:
4 3 100
Sample Output:
6	0	-6
2	-9	-4
7	7	3
0	-9	-8
2
1
NO
1

*/

public class Generate2DArrayFindFirstNegativeInARow {
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

        Arrays.stream(nums).forEach(Generate2DArrayFindFirstNegativeInARow::printArray);

        Arrays.stream(nums).forEach(row -> {
            boolean foundNegative = false;
            for (int index = 0; index < row.length; index++) {
                if (row[index] < 0) {
                    System.out.println(index);
                    foundNegative = true;
                    break; // Exit the loop once a negative number is found
                }
            }
            if (!foundNegative) {
                System.out.println("NO");
            }
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
