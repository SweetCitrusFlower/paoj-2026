package com.pao.laboratory03.exercise.exception;

public class StudentNotFoundException extends RuntimeException{
    private final String studentName;

    public StudentNotFoundException(String studentName) {
        super("Student negasit: Studentul " +  studentName + " nu exista");
        this.studentName = studentName;
    }

    public String getStudentName() {return studentName;}
}
