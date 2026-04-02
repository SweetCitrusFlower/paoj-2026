package com.pao.laboratory06.exercise2;

public abstract class Colaborator {
    private String nume;
    private String prenume;
    private double VenitBrutLunar;

    public Colaborator(String nume, String prenume, double VenitBrutLunar) {
        this.VenitBrutLunar = VenitBrutLunar;
        this.nume = nume;
        this.prenume = prenume;
    }
    
    public abstract double calculeazaVenitNetAnual();

    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public double getVenitBrutLunar() {
        return this.VenitBrutLunar;
    }
}
