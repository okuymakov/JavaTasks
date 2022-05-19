package ru.kuymakov.geometry;

public class Ellipse {
    Point coord;
    int r1, r2;

    private Ellipse(int r1, int r2, Point coord) {
        this.r1 = r1;
        this.r2 = r2;
        this.coord = coord;
    }

    public boolean isCircle() {
        return r1 == r2;
    }

    public static Ellipse createCircle(int r, Point coord) {
        return new Ellipse(r, r, coord);
    }

    public static Ellipse createEllipse(int r1, int r2, Point coord) {
        return new Ellipse(r1, r2, coord);
    }
}
