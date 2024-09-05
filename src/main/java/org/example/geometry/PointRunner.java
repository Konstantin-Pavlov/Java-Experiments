package org.example.geometry;

public class PointRunner {
    public static void main(String[] args) {
        PointGeneric<Integer> p0 = new PointGeneric<>(1, 3);
        PointGeneric<Integer> p1 = new PointGeneric<>(1, 3);
        PointGeneric<Double> p2 = new PointGeneric<>(0.32, 4.1);
        System.out.println(p1.add(p2));
        System.out.println(p1.subtract(p2));
        System.out.println(p1.ixEquals(p2));
        System.out.println(p0.ixEquals(p1));

    }
}


