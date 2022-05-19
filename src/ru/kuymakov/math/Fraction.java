package ru.kuymakov.math;

import java.util.ArrayList;
import java.util.List;
import ru.kuymakov.utiils.MathUtils;

public final class Fraction extends Number implements Cloneable {

    private int num;
    private int den;
    private static List<Fraction> fractions = new ArrayList<>();

    private Fraction(int num, int den) {
        if (den <= 0) {
            throw new IllegalArgumentException();
        }
        this.num = num;
        this.den = den;
    }

    public static Fraction createFraction(int num, int den) {
        for (Fraction fr : fractions) {
            if (fr.num == num && fr.den == den) {
                return fr;
            }
        }
        Fraction nFr = new Fraction(num, den);
        fractions.add(nFr);
        return nFr;
    }

    public Fraction reduce() {
        int div = MathUtils.gcd(num, den);
        if (div < 0) {
            div *= -1;
        }
        return new Fraction(num / div, den / div);
    }

    public Fraction add(Fraction fr) {
        int numt, dent;
        if (den != fr.den) {
            numt = num * fr.den + fr.num * den;
            dent = den * fr.den;
        } else {
            numt = num + fr.num;
            dent = den;
        }
        return new Fraction(numt, dent).reduce();
    }

    public Fraction add(int num) {
        return add(toFraction(num));
    }

    public Fraction sub(Fraction fr) {
        return add(fr.mult(-1));
    }

    public Fraction sub(int num) {
        return sub(toFraction(num));
    }

    public Fraction div(Fraction fr) {
        if (fr.num < 0) {
            return new Fraction(-num * fr.den, -den * fr.num).reduce();
        }
        return new Fraction(num * fr.den, den * fr.num).reduce();
    }

    public Fraction div(int num) {
        return div(toFraction(num));
    }

    public Fraction mult(Fraction fr) {
        return new Fraction(num * fr.num, den * fr.den).reduce();
    }

    public Fraction mult(int num) {
        return mult(toFraction(num));
    }

    Fraction toFraction(int num) {
        return new Fraction((int) Math.pow(num, 3), num * num);
    }

    @Override
    public int intValue() {
        return num / den;
    }

    @Override
    public long longValue() {
        return num / (long) den;
    }

    @Override
    public float floatValue() {
        return num / (float) den;
    }

    @Override
    public double doubleValue() {
        return num / (double) den;
    }

    @Override
    public Fraction clone() throws CloneNotSupportedException {
        return (Fraction) super.clone();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.num;
        hash = 43 * hash + this.den;
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
        final Fraction other = (Fraction) obj;
        if (this.num != other.num) {
            return false;
        }
        if (this.den != other.den) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}
