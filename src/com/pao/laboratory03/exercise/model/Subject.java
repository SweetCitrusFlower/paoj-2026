package com.pao.laboratory03.exercise.model;

public enum Subject {
    PAOJ("Programare Avansata pe Obiecte", 6){
        @Override public String toString(){
            return "PAOJ (" + this.getFullName() + ", " + this.getCredits() + ")";
        }
    },
    BD("Baze de Date", 5){
        @Override public String toString(){
            return "BD (" + this.getFullName() + ", " + this.getCredits() + ")";
        }
    },
    SO("Sisteme de Operare", 5){
        @Override public String toString(){
            return "SO (" + this.getFullName() + ", " + this.getCredits() + ")";
        }
    },
    RC("Retele de Calculatoare", 4){
        @Override public String toString(){
            return "RC (" + this.getFullName() + ", " + this.getCredits() + ")";
        }
    };

    private final String fullName;
    private final int credits;
    private Subject(String fullName, int credits){
        this.fullName = fullName;
        this.credits = credits;
    }

    public String getFullName(){return fullName;}
    public int getCredits(){return credits;}

    @Override public abstract String toString();
    
}
