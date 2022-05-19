package ru.kuymakov.animals.birds;

import java.util.Random;

public class Parrot extends Bird {

    private String text;
    Random rand = new Random();

    public Parrot(String text) {
        this.text = text;
    }

    @Override
    public void sing() {
        char[] bText = text.toCharArray();
        char tmp;
        int randInd;
        for (int i = 0; i < text.length(); i++) {
            tmp = bText[i];
            randInd = rand.nextInt(text.length() - 1);
            bText[i] = bText[randInd];
            bText[randInd] = tmp;
        }
        System.out.println(bText);
    }

}
