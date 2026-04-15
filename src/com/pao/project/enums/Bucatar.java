package com.pao.project.enums;

import com.pao.project.Locatie;

public class Bucatar extends Angajat{
    private Locatie locatiePrincipala;

    public Bucatar(String nume, String prenume, String nrTelefon, double salariu, Locatie locatie) {
        super(nume, prenume, nrTelefon, salariu);
        this.locatiePrincipala = locatie;
    }

    public Locatie getLocatie() {return locatiePrincipala;}
    public void schimbaLocatiePrincipala(Locatie locatieNoua){this.locatiePrincipala = locatieNoua;}
}
