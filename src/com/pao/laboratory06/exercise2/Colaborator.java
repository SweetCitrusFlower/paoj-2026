package com.pao.laboratory06.exercise2;

import java.text.DecimalFormat;

public abstract class Colaborator implements IOperatiiCitireScriere{
    String nume;
    String prenume;
    double VenitBrutLunar;
    TipColaborator tipColaborator;

    public Colaborator(TipColaborator tipColaborator, String nume, String prenume, double VenitBrutLunar) {
        this.VenitBrutLunar = VenitBrutLunar;
        this.nume = nume;
        this.prenume = prenume;
        this.tipColaborator = tipColaborator;
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
    
    @Override
    public String tipContract() {
        return this.getTip().name();
    }

    public TipColaborator getTip(){
        return this.tipColaborator;
    }

    @Override
    public void afiseaza() {
        DecimalFormat df = new DecimalFormat("#.00"); 
        System.out.println(this.tipContract() + ": " + this.getNume() + " " + this.getPrenume() + ", venit net anual: " + df.format(this.calculeazaVenitNetAnual()) + " lei");
    }


}
