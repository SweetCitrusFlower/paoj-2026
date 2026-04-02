package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class SRLColaborator extends Colaborator implements PersoanaJuridica{
    private double cheltuieliLunare;
    
    public SRLColaborator(String nume, String prenume, double VenitBrutLunar, double cheltuieliLunare) {
        super(TipColaborator.SRL, nume, prenume, VenitBrutLunar);
        this.cheltuieliLunare = cheltuieliLunare;
    }

    public SRLColaborator() {
        super(TipColaborator.SRL, "", "", 0);
        this.cheltuieliLunare = 0;
    }

    @Override
    public double calculeazaVenitNetAnual() {
        return (this.getVenitBrutLunar() - cheltuieliLunare) * 12 * 0.84;
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.VenitBrutLunar = Double.parseDouble(in.next());
        this.cheltuieliLunare = Double.parseDouble(in.next());        
    }
}
