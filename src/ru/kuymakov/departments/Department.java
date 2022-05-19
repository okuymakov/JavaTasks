package ru.kuymakov.departments;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    String name;
    Employee chief;
    List<Employee> emps;

    public Department(String name) {
        this.name = name;
        emps = new ArrayList<>();
    }

    public Department(String name, Employee chief) {
        this(name);
        this.chief = chief;
    }

    public void setChief(Employee emp) {
        if (this != emp.dep) {
            addEmployee(emp);
        } 
        chief = emp;
    }

    public void fireEmployee(Employee emp) {
        if (emps.contains(emp)) {
            emp.dep = null;
            if (emp == chief) {
                chief = null;
            }
            emps.remove(emp);
        } else {
            throw new IllegalArgumentException("Сотрудника нет в отделе");
        }
    }

    public void addEmployee(Employee emp) {
        if (!emps.contains(emp)) {
            if (emp.dep != null) {
                emp.dep.transferEmployee(emp, this);
            } else {
                emp.dep = this;
                emps.add(emp);
            }
        } else {
            throw new IllegalArgumentException("Сотрудник уже работает в отделе");
        }
    }

    public void transferEmployee(Employee emp, Department dep) {
        fireEmployee(emp);
        dep.addEmployee(emp);

    }

    public String getName() {
        return name;
    }

    public Employee getChief() {
        return chief;
    }

    public List<Employee> getEmps() {
        return new ArrayList<>(emps);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.emps);
        return hash;
    }
}
