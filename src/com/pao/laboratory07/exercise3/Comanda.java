package com.pao.laboratory07.exercise3;

import com.pao.laboratory07.exercise1.OrderState;

public abstract sealed class Comanda permits ComandaStandard, ComandaRedusa, ComandaGratuita {
    protected String nume;
    protected double pret;
    protected String client;

    protected OrderState orderState;
    protected TipComanda tipComanda;

    public Comanda(String nume, double pret, String client){
        this.nume = nume;
        this.pret = pret;
        this.client = client;

        this.orderState = OrderState.PLACED;
    }

    public Comanda(){
        this.nume = "";
        this.pret = 0.00;
        this.client = "";
    }

    protected void SetTipComanda(TipComanda tc){this.tipComanda = tc;}

    public String getNume(){return this.nume;}
    public double getPret(){return this.pret;}
    public String getClient(){return this.client;}
    public TipComanda getTipComanda(){return this.tipComanda;}

    public abstract double pretFinal();
    public abstract String descriere();
}