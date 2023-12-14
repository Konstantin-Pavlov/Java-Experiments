package org.example.pointsComparator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PointRunner {
    public static void main(String[] args) {
        Point[] students = new Point[]{
                new Point(1, 2),
                new Point(3, 7),
                new Point(-2, 3),
                new Point(1, 1),
                new Point(3, 5)
        };
        Arrays.sort(students);
        Arrays.stream(students).forEach(System.out::println);

//        withUserInput();
    }

    private static void withUserInput() {
        Scanner scanner = new Scanner(System.in);
        Point[] points = IntStream.range(0, scanner.nextInt())
                .mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
                .toArray(Point[]::new);
        Arrays.sort(points);
        Arrays.stream(points).forEach(System.out::println);
        scanner.close();
    }
}
