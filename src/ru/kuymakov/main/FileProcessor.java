
package ru.kuymakov.main;

public abstract class FileProcessor {
    abstract String open(String fileName);
    abstract String transform(String data);
    abstract void write(String fileName, String data);
    
    public void process(String fileName) {
        String data = open(fileName);
        String newData = transform(data);
        write(fileName,newData);
    }
}
