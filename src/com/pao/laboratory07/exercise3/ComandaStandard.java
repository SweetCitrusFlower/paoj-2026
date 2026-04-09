package com.pao.laboratory07.exercise3;

import java.text.DecimalFormat;

public final class ComandaStandard extends Comanda {

    public ComandaStandard(String nume, double pret, String client) {
        super(nume, pret, client);
        this.SetTipComanda(TipComanda.STANDARD);
    }

    @Override
    public double pretFinal() {
        return this.getPret();
    }

    @Override
    public String descriere() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return ("STANDARD: " + this.getNume() + ", pret: " + df.format(this.pretFinal()) + " lei [PLACED] - client: " + this.getClient());
    }
}
