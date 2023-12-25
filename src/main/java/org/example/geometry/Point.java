package org.example.geometry;

import java.util.Objects;

public class Point<T extends Number> {
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public Point<?> add(Point<?> another) {
        return new Point<>(
                this.x.doubleValue() + another.getX().doubleValue(),
                this.y.doubleValue() + another.getY().doubleValue()
        );
    }


    public boolean ixEquals(Point<? extends Number> another) {
        if (this == another) return true;
        return (this.x.doubleValue() == another.getX().doubleValue() &&
                this.y.doubleValue() == another.getY().doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
