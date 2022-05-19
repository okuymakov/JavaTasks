
package ru.kuymakov.tests;


public class Test1 implements Testable{

    @Override
    public boolean test(Object ob) {
        return ob.getClass() == String.class;
    }
    
}
