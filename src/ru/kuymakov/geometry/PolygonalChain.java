package ru.kuymakov.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolygonalChain implements Chainable, Lengthable {

    private List<Point> points;

    public PolygonalChain() {
        points = new ArrayList<>();
    }

    public PolygonalChain(Point... points) {
        this();
        for (Point point : points) {
            this.points.add(new Point(point));
        }
    }

    public void addPoints(Point... points) {
        for (Point point : points) {
            this.points.add(new Point(point));
        }
    }

    public List<Point> getPoints() {
        List<Point> copyPoints = new ArrayList<>();
        for (Point point : points) {
            copyPoints.add(new Point(point));
        }
        return copyPoints;
    }

    @Override
    public int length() {
        if (points.size() < 2) {
            return 0;
        }
        int length = 0;
        Point firstPoint;
        Point secondPoint;
        firstPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            secondPoint = points.get(i);
            length += Math.hypot(secondPoint.getX() - firstPoint.getX(), secondPoint.getY() - firstPoint.getY());
            firstPoint = secondPoint;
        }
        return length;
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.points);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PolygonalChain other = (PolygonalChain) obj;
        if (!Objects.equals(this.points, other.points)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Линия " + points;
    }
}
