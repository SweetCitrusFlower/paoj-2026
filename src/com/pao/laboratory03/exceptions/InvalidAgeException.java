package com.pao.laboratory03.exceptions;

public class InvalidAgeException extends RuntimeException {
    private final int age;

    public InvalidAgeException(int age) {
        super("Varsta invalida: varsta " +  age + " nu este valida (0-150)");
        this.age = age;
    }

    public int getAge() {return age;}
}
