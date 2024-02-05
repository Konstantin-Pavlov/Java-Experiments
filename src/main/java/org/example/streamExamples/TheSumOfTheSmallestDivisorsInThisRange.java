package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

/*Нужно найти сумму наименьших делителей всех чисел в этом диапазоне (рассматриваются делители, начиная с 2).

Например, для диапазона 8 ...11:
наименьший делитель 8 равен 2
наименьший делитель 9 равен 3
наименьший делитель 10 равен 2
наименьший делитель 11 равен 11
Сумма 2+3+2+11=18

Sample Input:
8 11
Sample Output:
18

*/
public class TheSumOfTheSmallestDivisorsInThisRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(IntStream.rangeClosed(scanner.nextInt(), scanner.nextInt())
                .map(value -> IntStream.rangeClosed(2, value)
                        .filter(divider -> value % divider == 0)
                        .findFirst().orElse(0))
                .sum());

        scanner.close();
    }
}
