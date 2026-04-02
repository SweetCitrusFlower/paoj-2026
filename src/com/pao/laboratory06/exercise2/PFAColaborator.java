package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class PFAColaborator extends Colaborator implements PersoanaFizica{
    private double cheltuieliLunare;

    public PFAColaborator(String nume, String prenume, double VenitBrutLunar, double cheltuieliLunare) {
        super(TipColaborator.PFA, nume, prenume, VenitBrutLunar);
        this.cheltuieliLunare = cheltuieliLunare;
    }

    public PFAColaborator() {
        super(TipColaborator.PFA, "", "", 0);
        this.cheltuieliLunare = 0;
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double venitNet = (this.getVenitBrutLunar() - cheltuieliLunare) * 12;
        double impozitPeVenit = venitNet * 0.1;

        double CASS = 0.1 * venitNet;
        double salariuMinimBrutLunar = 4050;
        double salariuMinimBrutAnual = salariuMinimBrutLunar * 12;
        if(venitNet < 6 * salariuMinimBrutAnual){
            CASS = 0.1 * (6 * salariuMinimBrutAnual);
        }
        else if(venitNet > 72 * salariuMinimBrutAnual){
            CASS = 0.1 * (72 * salariuMinimBrutAnual);
        }

        double CAS = 0;
        if(venitNet >= 12 * salariuMinimBrutAnual && venitNet <= 24 * salariuMinimBrutAnual){
            CAS = 0.25 * 12 * salariuMinimBrutAnual;
        }
        else if (venitNet > 24 * salariuMinimBrutAnual){
            CAS = 0.25 * 24 * salariuMinimBrutAnual;
        }

        return (venitNet - impozitPeVenit - CASS - CAS);
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.VenitBrutLunar = Double.parseDouble(in.next());
        this.cheltuieliLunare = Double.parseDouble(in.next());        
    }
}
