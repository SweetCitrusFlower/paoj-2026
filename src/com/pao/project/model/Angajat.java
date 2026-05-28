package com.pao.project.model;

public class Angajat extends Persoana{
    private double salariu;
    private boolean esteCurier;

    public Angajat(String nume, String prenume, String nrTelefon, double salariu, boolean esteCurier) {
        super(nume, prenume, nrTelefon);
        this.salariu = salariu;
        this.esteCurier = esteCurier;
    }

    @Override
    public double getSalariu() {return this.salariu;}
    public void marireSalariu(int i){this.salariu *= (1 + Double.valueOf(i)/100);}

    public boolean getEsteCurier() {return this.esteCurier;}
    public void setEsteCurier(boolean esteCurier) {this.esteCurier = esteCurier;}

    @Override
    public String toString(){
        return this.getNume() + " " + this.getPrenume() + ", nr. telefon: " + this.getNrTelefon() + ", salariu = " + this.getSalariu();
    }
}
