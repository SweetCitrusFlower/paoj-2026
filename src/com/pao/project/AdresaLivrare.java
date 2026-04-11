package com.pao.project;

public class AdresaLivrare extends Adresa{
    private final int nrApartament;

    public AdresaLivrare(String numeStrada, int nrStrada, int codPostal, int nrApartament) {
        super(numeStrada, nrStrada, codPostal);
        this.nrApartament = nrApartament;
    }

    public int getNrApartament() {
        return nrApartament;
    }
}
