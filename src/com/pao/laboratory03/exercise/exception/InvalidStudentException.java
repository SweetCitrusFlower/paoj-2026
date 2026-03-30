package com.pao.laboratory03.exercise.exception;

public class InvalidStudentException extends RuntimeException {
    private final int age;

    public InvalidStudentException(int age) {
        super("Varsta invalida: varsta " +  age + " nu este valida (18-60)");
        this.age = age;
    }

    public int getAge() {return age;}
}
