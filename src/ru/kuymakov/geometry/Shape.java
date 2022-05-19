package ru.kuymakov.geometry;

public abstract class Shape {

    Point coord;

    public abstract int area();

    public Shape(Point coord) {
        this.coord = new Point(coord);
    }

    public Point getCoord() {
        return new Point(coord);
    }

}
