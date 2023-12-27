package org.example.geometry;

public class Triangle<T extends Number> {
    Point<T> p1;
    Point<T> p2;
    Point<T> p3;

    Triangle(Point<T> p1, Point<T> p2, Point<T> p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    double calculateArea() {
        return Math.abs(
                0.5 * (
                        p1.getX().doubleValue() * (p2.getY().doubleValue() - p3.getY().doubleValue()) +
                        p2.getX().doubleValue() * (p3.getY().doubleValue() - p1.getY().doubleValue()) +
                        p3.getX().doubleValue() * (p1.getY().doubleValue() - p2.getY().doubleValue())
                )
        );
    }

}
