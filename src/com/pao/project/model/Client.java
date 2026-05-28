package com.pao.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client extends Persoana{

    private final String email;
    private final String parola;
    private final CardFidelitate cardFidelitate;
    private final List<Adresa> listaAdreseLivrare;
    private final List<Comanda> listaComenzi;

    public Client(String nume, String prenume, String nrTelefon, String email, String parola) {
        super(nume, prenume, nrTelefon);
        this.email = email;
        this.parola = parola;
        this.listaAdreseLivrare = new ArrayList<>();
        this.listaComenzi = new ArrayList<>();
        this.cardFidelitate = new CardFidelitate();
    }

    public String getEmail(){return this.email;}
    public String getParola(){return this.parola;}
    public CardFidelitate getCardFidelitate() {return this.cardFidelitate;} 
    public List<Adresa> getListaAdreseLivrare() {return List.copyOf(listaAdreseLivrare);}
    public List<Comanda> getListaComenzi() {return List.copyOf(listaComenzi);}


    public void adaugareAdresaLivrare(Adresa adr){
        this.listaAdreseLivrare.add(adr);
    }

    public void stergereAdresaLivrare(int idx){
        this.listaAdreseLivrare.remove(idx);
    }

    public void adaugareComanda(Comanda com){
        this.listaComenzi.add(com);
    }

    public void adaugareProduseInCardFidelitate(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            if(produs.getCategorieProdus() == CategorieProdus.BOL_POKE || produs.getCategorieProdus() == CategorieProdus.SALATA){
                cardFidelitate.addNrProduseIntroduse(en.getValue());
            }
            produs.popularitate += en.getValue();
        }
    }

    public void eliminaReducereDinCardFidelitateDupaIndice(int indice){
        this.getCardFidelitate().removeReducere(indice);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((parola == null) ? 0 : parola.hashCode());
        result = prime * result + ((cardFidelitate == null) ? 0 : cardFidelitate.hashCode());
        result = prime * result + ((listaAdreseLivrare == null) ? 0 : listaAdreseLivrare.hashCode());
        result = prime * result + ((listaComenzi == null) ? 0 : listaComenzi.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (parola == null) {
            if (other.parola != null)
                return false;
        } else if (!parola.equals(other.parola))
            return false;
        if (cardFidelitate == null) {
            if (other.cardFidelitate != null)
                return false;
        } else if (!cardFidelitate.equals(other.cardFidelitate))
            return false;
        if (listaAdreseLivrare == null) {
            if (other.listaAdreseLivrare != null)
                return false;
        } else if (!listaAdreseLivrare.equals(other.listaAdreseLivrare))
            return false;
        if (listaComenzi == null) {
            if (other.listaComenzi != null)
                return false;
        } else if (!listaComenzi.equals(other.listaComenzi))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return this.getNume() + " " + this.getPrenume() + ", nr. telefon: " + this.getNrTelefon() + ", email: " + this.getEmail();
    }

    @Override
    public double getSalariu() {
        return 0.0;
    }
}
