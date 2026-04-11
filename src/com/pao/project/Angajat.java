package com.pao.project;

public class Angajat extends Persoana{
    private double salariu;

    public Angajat(String nume, String prenume, String nrTelefon, double salariu) {
        super(nume, prenume, nrTelefon);
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }
}
