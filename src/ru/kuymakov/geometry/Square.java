package ru.kuymakov.geometry;

import ru.kuymakov.geometry.Shape;
import ru.kuymakov.geometry.PolygonalChain;

public class Square extends Shape implements Chainable {

    int a;

    public Square(Point leftUpVertex, int a) {
        super(leftUpVertex);
        if (a <= 0) {
            throw new IllegalArgumentException();
        }
        this.a = a;
    }

    public int getSide() {
        return a;
    }

    public void setSide(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        this.a = length;
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        Point rightUpVertex = new Point(coord.getX() + a, coord.getY());
        Point rightDownVertex = new Point(rightUpVertex.getX(), rightUpVertex.getY() - a);
        Point leftDownVertex = new Point(coord.getX(), coord.getY() - a);
        return new ClosedPolygonalChain(coord, rightUpVertex, rightDownVertex, leftDownVertex);
    }

    @Override
    public int area() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + coord + " со стороной " + a;
    }

}
