package ru.kuymakov.geometry;

public class Triangle extends Shape implements Chainable {

    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public int area() {
        double a = Math.hypot(p2.getX() - coord.getX(), p2.getY() - coord.getY());
        double b = Math.hypot(p3.getX() - p2.getX(), p3.getY() - p2.getY());
        double c = Math.hypot(p3.getX() - coord.getX(), p3.getY() - coord.getY());
        double p = (a + b + c) / 2;
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return new ClosedPolygonalChain(coord, p2, p3);
    }
}
