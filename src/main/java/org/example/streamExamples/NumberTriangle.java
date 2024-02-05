package org.example.streamExamples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input:
5
Sample Output:
55555
4444
333
22
1
*/
public class NumberTriangle {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, new Scanner(System.in).nextInt())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .forEach(var -> System.out.println(String.valueOf(var).repeat(var)));
    }
}
