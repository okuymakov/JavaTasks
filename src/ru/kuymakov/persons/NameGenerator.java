package ru.kuymakov.persons;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private static NameGenerator ng;
    private static List<Name> names = new ArrayList<>();

    private NameGenerator() {
    }

    public static Name generateName(String firstname, String surname, String patronymic) {
        for (Name name : names) {
            if (name.firstname.equals(firstname)
                    && name.surname.equals(surname)
                    && name.patronymic.equals(patronymic)) {
                return name;
            }
        }
        Name nName = new Name(firstname, surname, patronymic);
        names.add(nName);
        return nName;
    }

    public static Name generateName(String firstname) {
        return generateName(firstname, null, null);
    }

    public static Name generateName(String firstname, String surname) {
        return generateName(firstname, surname, null);
    }

    public static NameGenerator createNameGenerator() {
        if (ng == null) {
            ng = new NameGenerator();
        }
        return ng;
    }
}
