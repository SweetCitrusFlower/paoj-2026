package com.pao.project;

public class Adresa {
    private final String numeStrada;
    private final int nrStrada;
    private final int codPostal;

    public Adresa(String numeStrada, int nrStrada, int codPostal) {
        this.numeStrada = numeStrada;
        this.nrStrada = nrStrada;
        this.codPostal = codPostal;
    }

    public String getNumeStrada() {return numeStrada;}
    public int getNrStrada() {return nrStrada;}
    public int getCodPostal() {return codPostal;}
    
}
