package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input 1:
3 7 -> 3*4*5*6*7
Sample Output 1:
2520.0

Sample Input 2:
7 3
Sample Output 2:
2520.0*/
public class ReduceExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(
                IntStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                        .mapToDouble(value -> value)
                        .reduce(1.0, (x, y) -> x * y)
        );
        scanner.close();
    }
}

