package ru.kuymakov.houses;

public class House {

    final int countOfFloors;

    public House(int countOfFloors) {
        if (countOfFloors < 1) {
            throw new IllegalArgumentException();
        }
        this.countOfFloors = countOfFloors;
    }

    public String toString() {
        String endOfPhrase;
        if (countOfFloors % 10 == 1
                && countOfFloors % 100 != 11) {
            endOfPhrase = "этажом";
        } else {
            endOfPhrase = "этажами";
        }
        return "дом с " + countOfFloors + " " + endOfPhrase;
    }
}
