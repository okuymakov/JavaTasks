package ru.kuymakov;

public class Temperature {

    private String name;
    private int minT, maxT;
    private static Temperature ct = new Temperature("Холодно", -50, 10);
    private static Temperature nt = new Temperature("Нормально", 10, 25);
    private static Temperature ht = new Temperature("Жарко", 25, 60);

    private Temperature(String name, int minT, int maxT) {
        this.name = name;
        this.minT = minT;
        this.maxT = maxT;
    }

    public enum ETemperature {
        COLD, NORM, HOT
    };

    public static Temperature getTemperature(ETemperature type) {
        switch(type) {
            case COLD:
                return ct;
            case NORM:
                return nt;
            case HOT:
                return ht;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Temperature: " + name;
    }
    
    
}
