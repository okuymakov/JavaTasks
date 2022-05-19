package ru.kuymakov.animals.birds;

import java.util.Random;
import ru.kuymakov.utiils.StringUtils;

public class Cuckoo extends Bird {

    Random rand = new Random();

    @Override
    public void sing() {
        System.out.println(StringUtils.repeat("ку-ку ", rand.nextInt(10) + 1));
    }

}
