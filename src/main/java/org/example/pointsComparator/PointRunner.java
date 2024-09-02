package org.example.pointsComparator;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PointRunner {
    public static void main(String[] args) {
//        Point[] points = getTwoPoints();
//        Point.showTheComparisonResultOfTwoPoints(points);


        withoutUserInput();
//        withUserInput();
    }

    @NotNull
    private static Point[] getTwoPoints() {
        Scanner scanner = new Scanner(System.in);
        int numPoints = 2;
        Point[] points = new Point[numPoints];
        IntStream.range(0, numPoints)
                .forEach(i -> {
                    String[] coordinates = scanner.nextLine().split(" ");
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    points[i] = new Point(x, y);
                });
        scanner.close();
        return points;
    }


    private static void withoutUserInput() {
        Point[] points = new Point[]{
                new Point(1, 2),
                new Point(3, 7),
                new Point(-2, 3),
                new Point(1, 1),
                new Point(3, 5)
        };
        Arrays.sort(points);
        Arrays.stream(points).forEach(System.out::println);
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
