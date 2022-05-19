/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuymakov.students;

public class ExamResult {
    String subject;
    String lecturer;
    int grade;

    public ExamResult(String subject, String lecturer, int grade) {
        this.subject = subject;
        this.lecturer = lecturer;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return subject + ", " + lecturer + ", " + grade;
    }
    
    
}
