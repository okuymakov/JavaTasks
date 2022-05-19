package ru.kuymakov.animals.cats;

import ru.kuymakov.utiils.StringUtils;

public class Cat implements Meowable {

    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        mew(1);
    }

    public void mew(int n) {
        String sound;
        sound = StringUtils.repeat("мяу-", n - 1) + "мяу!";
        System.out.println(name + ": " + sound);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

}
