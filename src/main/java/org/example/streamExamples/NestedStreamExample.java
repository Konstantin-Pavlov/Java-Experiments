package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input:
5
Sample Output:
1	2	3	4	5
2	4	6	8	10
3	6	9	12	15
4	8	12	16	20
5	10	15	20	25
*/
public class NestedStreamExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IntStream.rangeClosed(1, n).forEach(row -> {
                    IntStream.rangeClosed(1, n).forEach(value -> System.out.print(value * row + "\t"));
                    System.out.println();
                }
        );
        scanner.close();
    }
}
