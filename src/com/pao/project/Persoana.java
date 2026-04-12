package com.pao.project;

public abstract class Persoana {
    private final String nume;
    private final String prenume;
    private final String nrTelefon;
    
    public Persoana(String nume, String prenume, String nrTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
    }
    
    public String getNume() {return nume;}
    public String getPrenume() {return prenume;}
    public String getNrTelefon() {return nrTelefon;}
}
