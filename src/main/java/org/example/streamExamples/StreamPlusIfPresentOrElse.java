package org.example.streamExamples;

import java.util.Arrays;
import java.util.Scanner;

/*
negative number - end of input
Sample Input:
6 7 6 -1
Sample Output:
6.3

-5 ->	No data
*/
public class StreamPlusIfPresentOrElse {
    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(value -> value >= 0)
                .average()
                .ifPresentOrElse(
                        average -> System.out.printf("%1f", average),
                        () -> System.out.println("No data")
                );
    }
}
