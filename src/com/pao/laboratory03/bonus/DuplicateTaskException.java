package com.pao.laboratory03.bonus;

public class DuplicateTaskException extends RuntimeException {
    private final String name;

    public DuplicateTaskException(String name) {
        super("\"" + name + "\" exista deja");
        this.name = name;
    }

    public String getName(){return name;}
}
