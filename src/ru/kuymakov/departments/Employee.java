package ru.kuymakov.departments;

public class Employee {

    String name;
    Department dep;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (dep == null) {
            return name;
        }
        if (dep.chief != null && this.equals(dep.chief)) {
            return name + " начальник отдела " + dep.name;
        }
        if (dep.chief == null) {
            return name + " работает в отделе " + dep.name;
        }
        return name + " работает в отделе " + dep.name + ", начальник которого " + dep.chief.name;
    }
}
