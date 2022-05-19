package ru.kuymakov.db;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    List<String> data;
    int maxcc, curcc;

    public DataBase(int maxcc) {
        this.maxcc = maxcc;
        curcc = 0;
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("value " + i);
        }
    }
}
