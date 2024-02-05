package org.example.streamExamples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Пользователь вводит два целых числа (границы отрезка числовой оси).
Границы могут быть введены некорректно (первое число больше второго).
В этом случае нужно границы переставить местами. Т.е. перебор должен быть всегда от меньшего к большему.

Найти в данном отрезке первое число с максимальной суммой цифр.
Для отрицательного числа при расчете суммы цифр знак не учитывается. Например, сумма цифр -324 равна 9.

Sample Input 1:
15 22
Sample Output 1:
19
Sample Input 2:
-16 5
Sample Output 2:
-9
*/
public class MaxDigitsSumInARange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int maxSumNumber = IntStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                .boxed()
                .max(Comparator.comparingInt(MaxDigitsSumInARange::sumOfDigits))
                .orElseThrow(); // Handle the case when there is no number

        System.out.println("Number with the maximum sum of digits: " + maxSumNumber);

        scanner.close();
    }

    private static int sumOfDigits(int number) {
        int sum = 0;

        while (number != 0) {
            sum += Math.abs(number % 10);
            number /= 10;
        }

        return sum;
    }
}
