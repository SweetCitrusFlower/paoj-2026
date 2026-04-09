package com.pao.laboratory07.exercise2;

import com.pao.laboratory07.exercise1.OrderState;

public abstract sealed class Comanda permits ComandaStandard, ComandaRedusa, ComandaGratuita {
    protected String nume;
    protected double pret;
    protected OrderState orderState;

    public Comanda(String nume, double pret){
        this.nume = nume;
        this.pret = pret;
        this.orderState = OrderState.PLACED;
    }

    public Comanda(){
        this.nume = "";
        this.pret = 0.00;
    }

    public String getNume(){return this.nume;}
    public double getPret(){return this.pret;}

    public abstract double pretFinal();
    public abstract String descriere();
}