package org.example.streamExamples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Пользователь вводит размер массива и начальное значение генератора случайных чисел.

Создать массив  чисел типа double заданного размера и заполнить его случайными числами от 0 до 2.
Распечатать исходный массив, используя метод toString() - в квадратных скобках, элементы через запятую.

С новой строки вывести на консоль сумму максимального и минимального элементов массива.

Sample Input:
5 25
Sample Output:
[1.4631897195641836, 0.10745131965527377, 1.2906709676610488, 0.14895347726291952, 0.012141832026828503]
1.4753315515910121

*/

public class RandomDoubles {
    final static int LOWER_LIMIT = 0;
    final static int UPPER_LIMIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();

        Random random = new Random(seed);
        double[] nums = random.doubles(n, LOWER_LIMIT, UPPER_LIMIT).toArray();

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.stream(nums).min().orElse(0.0)
                + Arrays.stream(nums).max().orElse(0.0)
        );
        scanner.close();
    }
}
