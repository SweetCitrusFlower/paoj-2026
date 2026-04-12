package com.pao.project;

public class Reducere {
    private final Produs produs;
    private final int procentReducere;
    
    public Reducere(Produs produs, int procentReducere) {
        this.produs = produs;
        this.procentReducere = procentReducere;
    }

    public Produs getProdus() {return produs;}
    public int getProcentReducere() {return procentReducere;}
}
