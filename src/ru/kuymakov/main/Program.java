package ru.kuymakov.main;

import ru.kuymakov.comments.Comment;
import ru.kuymakov.comments.Publication;
import ru.kuymakov.shooters.weapons.Gun;
import ru.kuymakov.shooters.Shooter;
import ru.kuymakov.shooters.weapons.MachineGun;
import ru.kuymakov.cities.City2;
import ru.kuymakov.cities.Way;
import ru.kuymakov.cities.City;
import ru.kuymakov.departments.Employee;
import ru.kuymakov.departments.Department;
import ru.kuymakov.geometry.Point;
import ru.kuymakov.math.Fraction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import ru.kuymakov.storages.Box;
import ru.kuymakov.storages.Storage;
import ru.kuymakov.Temperature;
import ru.kuymakov.geometry.Line;
import ru.kuymakov.geometry.Point3;
import ru.kuymakov.students.Saveable;
import ru.kuymakov.students.Student;
import ru.kuymakov.tests.Test1;
import ru.kuymakov.tests.TestWithException;
import ru.kuymakov.tests.Testable;
import static ru.kuymakov.utiils.MathUtils.strPow;


public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println(strPow("2", "3"));

        System.out.println(new Point(1, 2));
        System.out.println(new java.awt.Point(1, 2));

        Fraction fr1 = Fraction.createFraction(3, 5);
        Fraction fr2 = Fraction.createFraction(3, 5);
        System.out.println(fr1 == fr2);

        List<String> list = new ArrayList<>();
        list.add("afsg");
        list.add("baa");
        list.add("c");
        list.add("daaaa");

        list.sort(new StringComparator());
        System.out.println(list);

        Line<Point3> l = new Line<>(new Point3(0, 0, 0), new Point3(0, 5, 6));
        moveLine(l);
        System.out.println(l);

        Storage<String> st = Storage.createNullableStorage(null);
        System.out.println(st.getElOrDefaultValue("hello"));

        List<Integer> list2 = new ArrayList<>();
        fillList(list2);
        System.out.println(list2);
        System.out.println(findMax(Storage.createNullableStorage(1.3)));
        Box<Point3> b = new Box<>(null);
        putPointInBox(b);
        System.out.println((Point) b.getEl());

        //Student student1 = new Student("Вася", Student.Rule.ALL, 3,10);
        //Student student2 = new Student("Петя", Student.Rule.FROM2TO5, 3, 4);
        //Student student3 = new Student("Иван", Student.Rule.ONLY4AND5, 4, 5);
        
        //run(student1, new TestWithException(new Test1()));
    }
    
    public static void run(Object ob, Testable... tests) {
        for(Testable test : tests) {
            test.test(ob);
        }
    }
    
    public static <T extends Point> void moveLine(Line<T> line) throws CloneNotSupportedException {
        T start = line.getStart();
        start.setX(start.getX() + 10);
        line.setStart(start);
    }

    public static double findMax(Storage<? extends Number>... storages) {
        double max = 0;
        for (Storage<? extends Number> storage : storages) {
            if (storage.getEl() != null) {
                max += storage.getEl().doubleValue();
            }
        }
        return max;
    }

    public static void putPointInBox(Box<? super Point3> b) {
        b.addEl(new Point3(0, 0, 0));
    }

    public static void fillList(List<? super Integer> list) {
        list.clear();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

}
