package org.example.streamExamples;

import java.util.*;
import java.util.stream.IntStream;

/*

Массив из целых чисел заполнить случайными значениями от -5 до 15 (включая обе границы)
Пользователь вводит размер массива, а затем начальное значение генератора случайных чисел.

Вывести исходный массив на консоль в одной строке, разделяя элементы пробелами.
Пробел должен быть в том числе и после последнего элемента массива.

Поменять местами первый максимальный и последний отрицательный элементы.
Если отрицательных элементов нет в массиве, то он должен остаться без изменения.

C новой строки вывести измененный массив, отделяя элементы пробелами.


Sample Input:
10 77
Sample Output:
7 -5 -1 5 -3 8 2 -1 -3 -3
7 -5 -1 5 -3 -3 2 -1 -3 8

*/

public class DoubleStreamGenerateRandomSwapMinMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        Random random = new Random(seed);
        List<Integer> numbers = new ArrayList<>(IntStream
                .generate(() -> random.nextInt(-5, 16))
                .limit(n)
                .boxed()
                .toList()
        );

        int firstMaxIndex = getTheLastMinValueIndex(numbers);
        int lastNegativeIndex = getTheFirstMaxValueIndex(numbers);

        printNumbers(numbers);

        // Swap if both last negative and first maximum elements are found
        if (lastNegativeIndex != -1 && firstMaxIndex != -1) {
            Collections.swap(numbers, lastNegativeIndex, firstMaxIndex);
        }

        printNumbers(numbers);

        scanner.close();
    }

    // Find the index of the first maximum element
    private static int getTheFirstMaxValueIndex(List<Integer> numbers) {
        return numbers.indexOf(Collections.max(numbers));
    }

    // Find the last negative element index
    private static int getTheLastMinValueIndex(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i) < 0)
                .reduce((first, second) -> second)
                .orElse(-1);
    }

    // print numbers
    private static void printNumbers(List<Integer> numbers) {
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
