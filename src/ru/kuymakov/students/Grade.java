
package ru.kuymakov.students;

import java.util.function.Predicate;

public class Grade implements Average {
    private int grade;
    private Predicate<Integer> gp;
    
    public Grade(int grade, Predicate<Integer> gp) {
        this.gp = gp;
        if (!gp.test(grade)) {
                throw new IllegalArgumentException();
        }
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    
    public enum Rule implements Predicate<Average> {
        ALL {
            @Override
            public boolean test(Average grade) {
                return true;
            }
        },
        FROM2TO5 {
            @Override
            public boolean test(Average grade) {
                return grade.averageGrade() >= 2 && grade.averageGrade() <= 5;
            }
        },
        ONLY4AND5 {
            @Override
            public boolean test(Average grade) {
                return grade.averageGrade() == 4 || grade.averageGrade() == 5;
            }
        }
    }
   
    @Override
    public double averageGrade() {
         return grade;
    }

}
