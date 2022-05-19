package ru.kuymakov.utiils;

import java.util.List;
import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;

public class MathUtils {

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    public static double average(List<Double> nums) {
        if (nums.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum / (double) nums.size();
    }

    public static double strPow(String num1, String num2) {
        int pnum1 = parseInt(num1);
        int pnum2 = parseInt(num2);
        return pow(pnum1, pnum2);
    }
}
