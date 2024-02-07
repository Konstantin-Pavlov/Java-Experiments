package org.example.streamExamples;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/*
Массив из вещественных чисел типа double заполнить случайными значениями от 0 до 5 (не включая).
Пользователь вводит размер массива, а затем начальное значение генератора случайных чисел.

Вывести исходный массив на консоль в одной строке, разделяя элементы пробелами.
Пробел должен быть в том числе и после последнего элемента массива.

Найти среднее арифметическое элементов массива и вывести его с новой строки.
Заменить все элементы, большие среднего, его значением.

C новой строки вывести преобразованный массив. Элементы отделяются пробелами.

Все вещественные числа при выводе округляются до двух знаков после десятичной точки.


Sample Input:
10 45
Sample Output:
3.63 4.35 1.50 3.77 1.29 3.07 2.09 4.80 4.70 3.77
3.30
3.30 3.30 1.50 3.30 1.29 3.07 2.09 3.30 3.30 3.30

*/

public class DoubleStreamGenerateRandom {
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        Random random = new Random(seed);
        double[] nums = DoubleStream
                .generate(() -> random.nextDouble(LOWER_LIMIT, UPPER_LIMIT))
                .limit(n)
                .toArray();

        double average = Arrays.stream(nums).average().orElse(0.0);

        double[] modifiedNums = Arrays.stream(nums).map(element -> Math.min(element, average)).toArray();

        printArray(nums);
        System.out.printf("%.2f%n", average);
        printArray(modifiedNums);

        scanner.close();
    }

    private static void printArray(double[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.printf("%.2f ", num));
        System.out.println();
    }
}
