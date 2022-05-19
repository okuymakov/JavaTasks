package ru.kuymakov.geometry;

public class Point3 extends Point{
    private int z;
    
    public Point3(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";"+ z + "}";
    }
}
