
package ru.kuymakov.main;

import ru.kuymakov.animals.birds.Bird;
import ru.kuymakov.animals.cats.Meowable;
import ru.kuymakov.geometry.Lengthable;
import ru.kuymakov.geometry.Shape;

public class PolymorphMethods {

    private PolymorphMethods() {
    }
    
    public static double sum(Number... nums) {
        double sum = 0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void singAll(Bird... birds) {
        for (Bird bird : birds) {
            bird.sing();
        }
    }

    public static int areaAll(Shape... shapes) {
        int area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }
        return area;
    }

    public static int lengthAll(Lengthable... ms) {
        int length = 0;
        for (Lengthable m : ms) {
            length += m.length();
        }
        return length;
    }

    public static void meowAll(Meowable... meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}
