package ru.kuymakov.students;

import java.util.ArrayList;
import java.util.List;
import ru.kuymakov.utiils.MathUtils;

public class Subject implements Average {
    String name;
    Grade grade;
    List<Average> modules;

    public Subject(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
        modules = new ArrayList<>();
    }
    
    
    @Override
    public double averageGrade() {
        return 0;//MathUtils.average(modules.stream().
                //map(module -> module.averageGrade()).toList());
    }
}
