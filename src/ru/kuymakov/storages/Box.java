
package ru.kuymakov.storages;


public class Box<T> {
    T el;
    
    public Box(T el) {
        this.el = el;
    }

    public T getEl() {
        T elt = el;
        el = null;
        return elt;
    }

    public void addEl(T el) {
        if(!isEmpty()) {
            throw new RuntimeException();
        }
        this.el = el;
    }
    
    public boolean isEmpty() {
        return el == null;
    }
    
    
}
