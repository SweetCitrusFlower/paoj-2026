package com.pao.laboratory07.exercise3;

import java.text.DecimalFormat;

public final class ComandaRedusa extends Comanda {
    private int discountProcent;

    public ComandaRedusa(String nume, double pret,int discountProcent, String client) {
        super(nume, pret, client);
        this.discountProcent = discountProcent;
        this.SetTipComanda(TipComanda.DISCOUNTED);
    }

    public int getDiscount(){return this.discountProcent;}

    @Override
    public double pretFinal() {
        return this.getPret() * (1 - Double.valueOf(this.discountProcent) / 100);
    }
    
    @Override
    public String descriere() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return ("DISCOUNTED: " + this.getNume() + ", pret: " + df.format(this.pretFinal()) + " lei (-" + this.discountProcent + "%) [PLACED] - client: " + this.getClient());
    }

}
