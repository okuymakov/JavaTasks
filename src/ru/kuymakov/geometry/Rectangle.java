package ru.kuymakov.geometry;

public class Rectangle extends Shape implements Chainable{
    private int a, b;

    public Rectangle(int a, int b, Point leftUpVertex) {
        super(leftUpVertex);
        this.a = a;
        this.b = b;
    }

    public int getHeight() {
        return b;
    }

    public void setHeight(int b) {
        this.b = b;
    }

    public int getWidth() {
        return a;
    }

    public void setWidth(int a) {
        this.a = a;
    }
    
    @Override
    public PolygonalChain getPolygonalChain() {
        Point rightUpVertex = new Point(coord.getX() + a, coord.getY());
        Point rightDownVertex = new Point(rightUpVertex.getX(), rightUpVertex.getY() - b);
        Point leftDownVertex = new Point(coord.getX(), coord.getY() - b);
        return new ClosedPolygonalChain(coord, rightUpVertex, rightDownVertex, leftDownVertex);
    }
    
    @Override
    public int area() {
        return a * b;
    }

}
