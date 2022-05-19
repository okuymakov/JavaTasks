package ru.kuymakov.time;

public class Time2 extends Time {

    private int timeZone;

    public Time2(int timeZone, int s) {
        super(s);
        if (timeZone < -12 || timeZone > 14) {
            throw new IllegalArgumentException();
        }
        this.timeZone = timeZone;
    }

    public Time2(int timeZone, int h, int m, int s) {
        super(h, m, s);
        if (timeZone < -12 || timeZone > 14) {
            throw new IllegalArgumentException();
        }
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return ((timeZone < 0) ? "-" : "+") + asString(getHour())
                + ":" + asString(getMinute()) + " " + Math.abs(timeZone);
    }

}
