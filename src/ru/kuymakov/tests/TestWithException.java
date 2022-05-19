
package ru.kuymakov.tests;

public class TestWithException implements Testable{
    private Testable test;

    public TestWithException(Testable test) {
        this.test = test;
    }
    
    @Override
    public boolean test(Object ob) {
        if(!test.test(ob)) throw new RuntimeException();
        return true;
    }
    
}
