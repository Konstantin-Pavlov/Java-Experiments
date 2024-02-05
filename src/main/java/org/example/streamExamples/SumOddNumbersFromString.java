package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.Collectors;

/*
Sample Input 1:
367
Sample Output 1:
10

Sample Input 2:
-351
Sample Output 2:
9
 */

public class SumOddNumbersFromString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\D", "");
        Object object = input.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .filter(n -> n % 2 == 1)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.isEmpty()) {
                        System.out.println("NO");
                    } else if (input.length() != 3) {
                        System.out.println("ERROR");
                    } else {
                        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
                    }
                    return null;
                }));
        System.out.println(object);
        scanner.close();
    }
}

