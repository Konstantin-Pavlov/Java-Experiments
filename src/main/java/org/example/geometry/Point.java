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

    // Method to add two points
    public Point<?> add(Point<?> another) {
        return new Point<>(
                this.x.doubleValue() + another.getX().doubleValue(),
                this.y.doubleValue() + another.getY().doubleValue()
        );
    }

    // Method to subtract two points
    public Point<?> subtract(Point<?> another) {
        return new Point<>(
                this.x.doubleValue() - another.getX().doubleValue(),
                this.y.doubleValue() - another.getY().doubleValue()
        );
    }

    // Method to calculate Euclidean distance between two points
    public double distanceTo(Point<?> another) {
        double dx = this.x.doubleValue() - another.getX().doubleValue();
        double dy = this.y.doubleValue() - another.getY().doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Method to scale a point by a factor
    public Point<?> scale(double factor) {
        return new Point<>(this.x.doubleValue() * factor, this.y.doubleValue() * factor);
    }

    @SuppressWarnings("unchecked")
    public void translateX(T xShift) {
        this.x = (T) Double.valueOf(this.x.doubleValue() + xShift.doubleValue());
    }

    @SuppressWarnings("unchecked")
    public void translateY(T yShift) {
        this.y = (T) Double.valueOf(this.x.doubleValue() + yShift.doubleValue());
    }

    // Method to translate a point by specified amounts
    public void translateXY(T deltaX, T deltaY) {
        this.translateX(deltaX);
        this.translateY(deltaY);
    }

    // Method to clone a point
    @SuppressWarnings("unchecked")
    public Point<T> clone() {
        try {
            return (Point<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e); // This should never happen
        }
    }

    // Method to check if a point is at the origin (0, 0)
    public boolean isOrigin() {
        return this.x.doubleValue() == 0 && this.y.doubleValue() == 0;
    }

    // Method to calculate the angle between two points with respect to the positive x-axis
    public double angleTo(Point<?> another) {
        double dx = another.getX().doubleValue() - this.x.doubleValue();
        double dy = another.getY().doubleValue() - this.y.doubleValue();
        return Math.atan2(dy, dx);
    }

    // Method to determine the quadrant in which a point lies
    public int getQuadrant() {
        if (this.x.doubleValue() >= 0 && this.y.doubleValue() >= 0) return 1;
        if (this.x.doubleValue() < 0 && this.y.doubleValue() >= 0) return 2;
        if (this.x.doubleValue() < 0 && this.y.doubleValue() < 0) return 3;
        return 4;
    }

    // Method to calculate the midpoint between two points
    public Point<?> midpoint(Point<?> another) {
        double midX = (this.x.doubleValue() + another.getX().doubleValue()) / 2;
        double midY = (this.y.doubleValue() + another.getY().doubleValue()) / 2;
        return new Point<>(midX, midY);
    }

    // Method to check if two points are equal
    public boolean ixEquals(Point<? extends Number> another) {
        if (this == another) return true;
        return (this.x.doubleValue() == another.getX().doubleValue() &&
                this.y.doubleValue() == another.getY().doubleValue());
    }

    // Method to calculate the hash code for the point
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Method to represent the point as a string
    @Override
    public String toString() {
        return String.format("Point{x = %.3f, y = %.3f}", getX().doubleValue(), getY().doubleValue());
    }
}
