
package ru.kuymakov.students;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Average> {
    private List<Boolean> visited = new ArrayList<>();
    private Deque<Average> grades = new ArrayDeque<>();
    private Average next;
    
    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Average next() {
        //
        return next;
    }
    
}
