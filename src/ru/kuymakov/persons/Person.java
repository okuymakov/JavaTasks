package ru.kuymakov.persons;

public class Person {

    private Person father;
    private Name name;
    private int height;

    public Person(Name name, int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.height = height;
    }
   
    public Person(Name name, int height, Person father) {
        this(name, height);
        this.father = father;
        setNameAccordingFather();
    }

    public Person getFather() {
        return father;
    }

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    private void setNameAccordingFather() {
        if (name.getSurname() == ""
                && father.name.getSurname() != "") {
            name = new Name(name.getFirstname(),father.name.getSurname(), name.getPatronymic());
        }

        if (name.getPatronymic() == ""
                && father.name.getFirstname() != "") {
            name = new Name(name.getFirstname(),name.getSurname(),father.name.getFirstname() + "ович");
        }
    }

    public String toString() {
        return name + "," + height;
    }
}
