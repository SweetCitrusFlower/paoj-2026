package com.pao.project.model;

public abstract class Persoana {
    private long id;
    private final String nume;
    private final String prenume;
    private final String nrTelefon;
    
    public Persoana(String nume, String prenume, String nrTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
    }

    public long getId() {return id;}
    public String getNume() {return nume;}
    public String getPrenume() {return prenume;}
    public String getNrTelefon() {return nrTelefon;}

    public void setId(long id) {this.id = id;}

    public abstract double getSalariu();

}
