package com.pao.laboratory03.exercise.exception;

public class InvalidGradeException extends RuntimeException {
    private final int grade;

    public InvalidGradeException(int grade) {
        super("Nota invalida: nota " +  grade + " nu este valida (1-10)");
        this.grade = grade;
    }

    public int getGrade() {return grade;}
}
