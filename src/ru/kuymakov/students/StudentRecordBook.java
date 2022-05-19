package ru.kuymakov.students;

public class StudentRecordBook {
    long number;
    String studentName;
    ExamResult[] records;

    public StudentRecordBook(String studentName, long number, ExamResult... records) {
        this.number = number;
        this.studentName = studentName;
        this.records = records;
    }

    @Override
    public String toString() {
        String recs = "";
        for(ExamResult record : records) {
            recs += "    " + record + "\n";
        }
        return studentName + ", " + number + ":\n" + recs;
    }
    
    
}
