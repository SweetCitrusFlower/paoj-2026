package com.pao.project;

public class Bucatar extends Angajat{
    private Locatie locatiePrincipala;

    public Bucatar(String nume, String prenume, String nrTelefon, double salariu, Locatie locatie) {
        super(nume, prenume, nrTelefon, salariu);
        this.locatiePrincipala = locatie;
    }

    public Locatie getLocatie() {return locatiePrincipala;}

}
