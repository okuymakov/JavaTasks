package ru.kuymakov.students;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import ru.kuymakov.utiils.MathUtils;

public class Student implements Comparable<Student>, Iterable {
    
    private String name;
    private List<Average> grades;
    private final Deque<Action> actions = new ArrayDeque<>();
    private List<StudentObserver> observers;

    public Student(String name, Average... grades) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(grades));
        observers = new ArrayList<>();
    }
    
    public void notifyObservers(Average grade) {
        for(StudentObserver observer : observers) {
            observer.call(this, grade);
        }
    }
    
    void addObserver(StudentObserver observer) {
        observers.add(observer);
    }
    
    void removeObserver(StudentObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public Iterator iterator() {
        return new StudentIterator();
    }


    public double averageGrade() {
        return 0;//MathUtils.average(grades.stream().map(grade -> grade.averageGrade()).toList());
    }
    
    private class Save implements Saveable<Student> {

        private String name;
        private List<Average> grades;

        @Override
        public void load() {
            Student.this.name = name;
            Student.this.grades = new ArrayList<>(grades);
            actions.clear();
        }
    }
    
    public Saveable<Student> save() {
        Save s = new Save();
        s.name = name;
        s.grades = new ArrayList<>(grades);
        return s;
    }

    public List<Average> getGrades() {
        return new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        String curName = this.name;
        actions.push(() -> this.name = curName);
        this.name = newName;
    }

    public void addGrade(Average grade) {
        actions.push(() -> removeGrade());
        grades.add(grade);
        notifyObservers(grade);
    }

    public void removeGrade() {
        Average lastGrade = grades.get(grades.size() - 1);
        actions.push(() -> addGrade(lastGrade));
        grades.remove(grades.size() - 1);
    }

    public void undo() {
        actions.pop().action();
    }

    public boolean isExcellentStudent() {
        if (grades.size() < 1) {
            return false;
        }
        for (Average grade : grades) {
            if (grade.averageGrade() != 5) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.grades);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.grades, other.grades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }

    @Override
    public int compareTo(Student s) {
        return (int) (averageGrade() - s.averageGrade());
    }

}
