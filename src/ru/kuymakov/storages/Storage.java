package ru.kuymakov.storages;

import java.util.Optional;

public class Storage<T> {

    private T el;

    private Storage(T el) {
        this.el = el;
    }

    public static <T> Storage createNullableStorage(T el) {
        return new Storage(el);
    }

    public static <T> Storage createStorage(T el) {
        if (el == null) {
            throw new RuntimeException();
        }
        return new Storage(el);
    }
    public T getEl() {
        return el;
    }
    public T getElOrDefaultValue(T defV) {    
        return Optional.ofNullable(el).orElse(defV);
    }
    
}
