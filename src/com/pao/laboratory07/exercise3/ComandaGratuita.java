package com.pao.laboratory07.exercise3;

public final class ComandaGratuita extends Comanda {

    public ComandaGratuita(String nume, String client) {
        super(nume, 0.00, client);
        this.SetTipComanda(TipComanda.GIFT);
    }

    @Override
    public double pretFinal() {
        return 0.00;
    }

    @Override
    public String descriere() {
       return ("GIFT: " + this.getNume() + ", gratuit [PLACED] - client: " + this.getClient());
    }

}
