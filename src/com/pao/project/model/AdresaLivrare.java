package com.pao.project.model;

public class AdresaLivrare extends Adresa{
    private final int nrApartament;

    public AdresaLivrare(String numeStrada, int nrStrada, int codPostal, int nrApartament) {
        super(numeStrada, nrStrada, codPostal);
        this.nrApartament = nrApartament;
    }

    public int getNrApartament() {return nrApartament;}

    @Override
    public String toString(){
        return "Strada '" + this.getNumeStrada() + "', nr. " + this.getNrStrada() + ", ap. " + this.getNrApartament() + ", cod postal " + this.getCodPostal();
    }
}
