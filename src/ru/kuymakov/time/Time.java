package ru.kuymakov.time;

public class Time {

    private int h;
    private int m;
    private int s;

    public Time(int s) {
        convert(s);
    }

    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }  
    
    void convert(int s) {
        h = s / 3600;
        while (h > 24) {
            h -= 24;
        }
        s %= 3600;
        m = s / 60;
        s %= 60;
        this.s = s;
    }

    String asString(int t) {
        if (t >= 0 && t <= 9) {
            return "0" + t;
        } else {
            return Integer.toString(t);
        }
    }

    public int getHour() {
        return h;
    }

    public int getMinute() {
        return m;
    }

    public int getSecond() {
        return s;
    }
    
    
    
    public String toString() {
        return asString(h) + ":" + asString(m) + ":" + asString(s);
    }
}
