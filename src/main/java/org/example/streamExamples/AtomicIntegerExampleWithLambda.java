package org.example.streamExamples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*
Sample Input 1:
7
Sample Output 1:
*******
 *****
  ***
   *

Sample Input 2:
4
Sample Output 2:
****
 **
 */
public class AtomicIntegerExampleWithLambda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("ERROR");
            return;
        }
        AtomicInteger i = new AtomicInteger(0);
        IntStream.rangeClosed(1, n)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .forEach(var -> {
                    if (var - i.get() < 0) {
                        return;
                    }
                    String pattern = "*".repeat(var - i.get());
                    String spaces = " ".repeat(i.get());
                    System.out.printf("%s%s%s%n", spaces, pattern, spaces);
                    i.incrementAndGet();
                });
        scanner.close();
    }
}
