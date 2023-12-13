package org.example.pointsComparator;

/*
https://stepik.org/lesson/90696/step/5?auth=login&unit=66924
sort up all points by increasing their distance from the origin of coordinates
and display the sorted list of points on the screen in the format:
(1:2)
(2:7)
 */

class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        double distance1 = Math.sqrt(x * x + y * y);
        double distance2 = Math.sqrt(other.x * other.x + other.y * other.y);
        return Double.compare(distance1, distance2);
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", x, y);
    }
}
