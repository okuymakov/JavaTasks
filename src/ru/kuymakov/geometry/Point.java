package ru.kuymakov.geometry;

public class Point implements Cloneable{

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.x, point.y);
    } 
    
    public static Point createPoint(int x, int y) {
        return new Point(x,y);
    }
    public static Point3 createPoint(int x, int y, int z) {
        return new Point3(x,y,z);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone(); 
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
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        return hash;
    }
    
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
