package org.example.geometry;

public class PointRunner {
    public static void main(String[] args) {
        Point<Integer> p0 = new Point<>(1, 3);
        Point<Integer> p1 = new Point<>(1, 3);
        Point<Double> p2 = new Point<>(0.32, 4.1);
        System.out.println(p1.add(p2));
        System.out.println(p1.subtract(p2));
        System.out.println(p1.ixEquals(p2));
        System.out.println(p0.ixEquals(p1));

    }
}


