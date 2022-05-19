package ru.kuymakov.geometry;

import ru.kuymakov.geometry.PolygonalChain;

public class ClosedPolygonalChain extends PolygonalChain {

    public ClosedPolygonalChain(Point... points) {
        super(points);
    }

    @Override
    public int length() {
        Point a = getPoints().get(0);
        Point b = getPoints().get(getPoints().size() - 1);
        return super.length() + (int) Math.hypot(b.getX() - a.getX(), b.getY() - a.getY());
    }
}
