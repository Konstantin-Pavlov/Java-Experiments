package org.example.pointsComparator;

/*
https://stepik.org/lesson/90696/step/5?auth=login&unit=66924
sort up all points by increasing their distance from the origin of coordinates
and display the sorted list of points on the screen in the format:
(1:2)
(2:7)
 */

class Point implements Comparable<Point> {
    private final double x;
    private final double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        double distance1 = Math.sqrt(x * x + y * y);
        double distance2 = Math.sqrt(other.x * other.x + other.y * other.y);
        return Double.compare(distance1, distance2);
    }

    public static void showTheComparisonResultOfTwoPoints(Point[] points) {
        if (points == null) {
            System.err.println("points array is null");
            return;
        }
        if (points.length != 2) {
            System.err.println("points array length should be 2");
            return;
        }

        int result = points[0].compareTo(points[1]);
        if (result < 0) {
            System.out.println("Первая точка ближе");
        } else if (result > 0) {
            System.out.println("Вторая точка ближе");
        } else {
            System.out.println("Точки на равных расстояниях");
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)", x, y);
    }
}
