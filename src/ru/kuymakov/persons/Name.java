package ru.kuymakov.persons;

import java.util.Objects;

public class Name {

    String firstname;
    String surname;
    String patronymic;

    Name(String firstname, String surname, String patronymic) {
        if (firstname == null || firstname == "") {
            throw new IllegalArgumentException();
        }
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.firstname);
        hash = 59 * hash + Objects.hashCode(this.surname);
        hash = 59 * hash + Objects.hashCode(this.patronymic);
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        String[] name = new String[]{firstname, patronymic, surname};
        String resName = "";
        for (String item : name) {
            if (item != null) {
                resName += item + " ";
            }
        }

        return resName.substring(0, resName.length() - 1);
    }
}
