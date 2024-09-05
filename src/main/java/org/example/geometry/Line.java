package org.example.geometry;

/**
 * The constructor takes two Point arguments, to be assigned to the two Point fields.
 * Additionally, we have an instance method that calculates the slope of Line
 * by using the fields, x and y, from each of the two Point fields.
 */
public class Line<T extends Number> {
    private final PointGeneric<T> p1;
    private final PointGeneric<T> p2;

    public Line(PointGeneric<T> p1, PointGeneric<T> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //  второй конструктор
    public Line(T x1, T y1, T x2, T y2) {
        this.p1 = new PointGeneric<>(x1, y1);
        this.p2 = new PointGeneric<>(x2, y2);
    }

    public double getSlope() {
        return (p1.getY().doubleValue() - p2.getY().doubleValue()) / (p1.getX().doubleValue() - p2.getX().doubleValue());
    }

    public double getLength() {
        return this.p1.distanceTo(p2);
    }

    public void translateX(T xShift) {
        this.p1.translateX(xShift);
        this.p2.translateX(xShift);
    }
    public void translateY(T yShift) {
        this.p1.translateY(yShift);
        this.p2.translateY(yShift);
    }

    public void translateXY(T shiftX, T shiftY) {
        p1.translateXY(shiftX, shiftY);
        p2.translateXY(shiftX, shiftY);
    }

    public PointGeneric<?> getMidpoint() {
        return this.p1.midpoint(p2);
    }
}
