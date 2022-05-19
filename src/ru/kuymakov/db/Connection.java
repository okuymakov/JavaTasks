package ru.kuymakov.db;

public class Connection {

    DataBase db;

    private Connection(DataBase db) {
        this.db = db;
    }

    public static Connection getConnection(DataBase db) {
        if (db.curcc == db.maxcc) {
            return null;
        }
        db.curcc++;
        return new Connection(db);
    }

    public String getItem(int ind) {
        if (ind >= 0 && ind < db.data.size()) {
            return db.data.get(ind);
        } else {
            return null;
        }
    }

    public void addItem(String item) {
        db.data.add(item);
    }
}
