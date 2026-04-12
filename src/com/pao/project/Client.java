package com.pao.project;

import com.pao.project.enums.CategorieProdus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client extends Persoana{
        
    private class CardFidelitate {
        private int nrProduseIntroduse;
        private final List<Reducere> listaReduceri;

        public CardFidelitate() {
            this.nrProduseIntroduse = 0;
            this.listaReduceri =  new ArrayList<>();
        }
    }

    private final String parola;
    private final CardFidelitate cardFidelitate;
    private final List<AdresaLivrare> listaAdreseLivrare;
    private final List<Comanda> listaComenzi;

    public Client(String nume, String prenume, String nrTelefon, String parola) {
        super(nume, prenume, nrTelefon);
        this.parola = parola;
        this.listaAdreseLivrare = new ArrayList<>();
        this.listaComenzi = new ArrayList<>();
        this.cardFidelitate = new CardFidelitate();
    }

    public String getParola(){return this.parola;}
    public int getNrProduseIntroduse() {return this.cardFidelitate.nrProduseIntroduse;}
    public List<Reducere> getListaReduceri() {return List.copyOf(cardFidelitate.listaReduceri);}
    public List<AdresaLivrare> getListaAdreseLivrare() {return List.copyOf(listaAdreseLivrare);}
    public List<Comanda> getListaComenzi() {return List.copyOf(listaComenzi);}

    public void adaugareAdresaLivrare(String numeStrada, int nrStrada, int codPostal, int nrApartament) {
        this.listaAdreseLivrare.add(new AdresaLivrare(numeStrada, nrStrada, codPostal, nrApartament));
    }

    public void stergereAdresaLivrare(int indice){
        this.listaAdreseLivrare.remove(indice);
    }

    public void AdaugareProduseInCardFidelitate(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            if(produs.getCategorieProdus() == CategorieProdus.BOL_POKE || produs.getCategorieProdus() == CategorieProdus.SALATA){
                cardFidelitate.nrProduseIntroduse += en.getValue();
                produs.cntComandat += en.getValue();
            }
        }
    }   
}
