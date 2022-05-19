
package ru.kuymakov.students;

import java.util.function.BiConsumer;


public class Mother implements StudentObserver{
    BiConsumer<Student,Average> onGettingGrade;
    public void subscribe(Student st, BiConsumer<Student,Average> onGettingGrade) {
        st.addObserver(this);
        this.onGettingGrade = onGettingGrade;
    }
    
    public void unsubscribe(Student st) {
        st.removeObserver(this);
    }

    @Override
    public void call(Student st, Average grade) {
        onGettingGrade.accept(st, grade);
    }
    
}
