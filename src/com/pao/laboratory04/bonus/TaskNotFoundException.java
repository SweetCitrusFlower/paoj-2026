package com.pao.laboratory03.bonus;

public class TaskNotFoundException extends RuntimeException {
    private final String name;

    public TaskNotFoundException(String name) {
        super("\"" + name + "\" nu exista");
        this.name = name;
    }

    public String getName(){return name;}
}
