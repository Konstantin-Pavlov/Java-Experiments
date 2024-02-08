package org.example.streamExamples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Пользователь вводит размер массива и начальное значение генератора случайных чисел.

Затем он вводит контрольный элемент (целое число).

Создать массив заданного размера и заполнить его случайными числами от 2 до 15.
Отсортировать массив по возрастанию. Распечатать отсортированный массив, используя метод toString() - в квадратных скобках, элементы через запятую.

Найти в отсортированном массиве индекс контрольного элемента и удалить все элементы после него (создать новый массив нужного размера).

Если контрольный элемент отсутствовал в массиве, то вывести "ERROR". В противном случае распечатать полученный массив методом toString().

Sample Input:
8 11
10
Sample Output:
[5, 6, 7, 10, 11, 13, 14, 15]
[5, 6, 7, 10]

*/

public class ArraysBinarySearchCopyOfExample {
    final static int LOWER_LIMIT = 2;
    final static int UPPER_LIMIT = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        int stop = scanner.nextInt();
        Random random = new Random(seed);
        int[] nums = IntStream
                .generate(() -> random.nextInt(LOWER_LIMIT, UPPER_LIMIT))
                .limit(n)
                .sorted()
                .toArray();

        int stopIndex = Arrays.binarySearch(nums, stop);

        if (stopIndex <= 0) {
            System.out.println("ERROR");
            return;
        }

        int[] modifiedNums = Arrays.copyOf(nums, stopIndex);

        System.out.println(Arrays.toString(modifiedNums));

        scanner.close();
    }
}
