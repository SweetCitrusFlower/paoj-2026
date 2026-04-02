package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class CIMColaborator extends Colaborator implements PersoanaFizica{
    private boolean areBonus;

    public CIMColaborator(String nume, String prenume, double VenitBrutLunar, boolean areBonus) {
        super(TipColaborator.CIM, nume, prenume, VenitBrutLunar);
        this.areBonus = areBonus;
    }

    public CIMColaborator() {
        super(TipColaborator.CIM, "", "", 0);
        this.areBonus = false;
    }

    @Override 
    public boolean areBonus(){
        return this.areBonus;
    }

    @Override
    public double calculeazaVenitNetAnual() {
        return this.getVenitBrutLunar() * 12 * 0.55 * (this.areBonus ? 1.1 : 1);
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.VenitBrutLunar = Double.parseDouble(in.next());
        this.areBonus = (in.next().compareTo("DA") == 0);        
    }
}
