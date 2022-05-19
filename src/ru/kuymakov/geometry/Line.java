package ru.kuymakov.geometry;

import java.util.Objects;

public class Line<T extends Point> implements Chainable, Lengthable, Cloneable {

    private T start;
    private T end;

    public Line(T start, T end) throws CloneNotSupportedException {
        this.start = (T) start.clone();
        this.end = (T) end.clone();
    }

    public static Line<Point> create(int x1, int y1, int x2, int y2)
            throws CloneNotSupportedException {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
    }

    public static Line<Point3> create(int x1, int y1, int z1, int x2, int y2, int z2)
            throws CloneNotSupportedException {
        return new Line<>(new Point3(x1, y1, z1), new Point3(x2, y2, z2));
    }

    public T getStart() throws CloneNotSupportedException {
        return (T) start.clone();
    }

    public void setStart(T start) throws CloneNotSupportedException {
        this.start = (T) start.clone();
    }

    public T getEnd() throws CloneNotSupportedException {
        return (T) end.clone();
    }

    public void setEnd(T end) throws CloneNotSupportedException {
        this.end = (T) end.clone();
    }

    @Override
    public int length() {
        return (int) Math.hypot(end.getX() - start.getX(), end.getY() - start.getY());
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return new PolygonalChain(start, end);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.start = start.clone();
        line.end = end.clone();
        return line;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.start);
        hash = 71 * hash + Objects.hashCode(this.end);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
