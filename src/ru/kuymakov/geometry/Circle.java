package ru.kuymakov.geometry;

public class Circle extends Shape {
    int r;

    public Circle(Point center, int r) {
        super(center);
        this.r = r;
    }

    @Override
    public int area() {
        return (int) Math.PI * r * r;
    }

}