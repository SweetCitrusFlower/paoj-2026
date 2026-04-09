package com.pao.laboratory07.exercise2;

import java.text.DecimalFormat;

public final class ComandaStandard extends Comanda {

    public ComandaStandard(String nume, double pret) {
        super(nume, pret);
    }

    @Override
    public double pretFinal() {
        return this.getPret();
    }

    @Override
    public String descriere() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return ("STANDARD: " + this.getNume() + ", pret: " + df.format(this.pretFinal()) + " lei [PLACED]");
    }
}
