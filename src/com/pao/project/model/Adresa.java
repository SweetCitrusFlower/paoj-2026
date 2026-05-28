package com.pao.project.model;

public class Adresa {
    private long id;
    private final String numeStrada;
    private final int nrStrada;
    private final int codPostal;
    private final int nrApartament;

    public Adresa(String numeStrada, int nrStrada, int codPostal, int nrApartament) {
        this.numeStrada = numeStrada;
        this.nrStrada = nrStrada;
        this.codPostal = codPostal;
        this.nrApartament = nrApartament;
    }

    public String getNumeStrada() {return String.format("%s",numeStrada);}
    public int getNrStrada() {return nrStrada;}
    public int getCodPostal() {return codPostal;}
    public int getNrApartament() {return nrApartament;}

    @Override
    public String toString(){
        return "Strada '" + this.getNumeStrada() + "', nr. " + this.getNrStrada() + ", ap. " + this.getNrApartament() + ", cod postal " + this.getCodPostal();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
