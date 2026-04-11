package com.pao.project;

import java.util.ArrayList;
import java.util.List;

public class Client extends Persoana{
    private CardFidelitate cardFidelitate;
    private List<AdresaLivrare> listaAdreseLivrare;

    public Client(String nume, String prenume, String nrTelefon) {
        super(nume, prenume, nrTelefon);
        this.listaAdreseLivrare = new ArrayList<>();
        this.cardFidelitate = null;
    }

    public CardFidelitate getCardFidelitate() {
        return cardFidelitate;
    }

    public List<AdresaLivrare> getListaAdreseLivrare() {
        return List.copyOf(listaAdreseLivrare);
    }

    public void setCardFidelitate() {
        this.cardFidelitate = new CardFidelitate();
    }

    public void adaugareAdresaLivrare(String numeStrada, int nrStrada, int codPostal, int nrApartament) {
        this.listaAdreseLivrare.add(new AdresaLivrare(numeStrada, nrStrada, codPostal, nrApartament));
    }
    
}
