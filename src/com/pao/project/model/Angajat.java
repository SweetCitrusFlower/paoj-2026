package com.pao.project.model;

public class Angajat extends Persoana{
    private double salariu;

    public Angajat(String nume, String prenume, String nrTelefon, double salariu) {
        super(nume, prenume, nrTelefon);
        this.salariu = salariu;
    }

    @Override
    public double getSalariu() {return salariu;}
    public void marireSalariu(int i){this.salariu *= (1 + Double.valueOf(i)/100);}

    @Override
    public String toString(){
        return this.getNume() + " " + this.getPrenume() + ", nr. telefon: " + this.getNrTelefon() + ", salariu = " + this.getSalariu();
    }
}
