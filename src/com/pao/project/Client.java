package com.pao.project;

import com.pao.project.enums.CategorieProdus;
import com.pao.project.enums.Produs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client extends Persoana{
        
    protected class CardFidelitate {
        private int nrProduseIntroduse;
        private List<Reducere> listaReduceri;

        public CardFidelitate() {
            this.nrProduseIntroduse = 0;
            this.listaReduceri = new ArrayList<>();
            this.listaReduceri.add(
                new Reducere("Aplica o reducere de 10% la toate produsele din comanda!",
                    (Comanda com) -> {
                        for(Produs pr : com.getProduseCantitate().keySet()){
                            pr.setDiscountProcent(10);    
                        }
                        return com;
                    })
                );
        }
            
        public int getNrProduseIntroduse() {return nrProduseIntroduse;}
        public List<Reducere> getListaReduceri() {return List.copyOf(listaReduceri);}
    }

    private final String email;
    private final String parola;
    private final CardFidelitate cardFidelitate;
    private final List<AdresaLivrare> listaAdreseLivrare;
    private final List<Comanda> listaComenzi;

    public Client(String nume, String prenume, String nrTelefon, String email, String parola) {
        super(nume, prenume, nrTelefon);
        this.email = email;
        this.parola = parola;
        this.listaAdreseLivrare = new ArrayList<>();
        this.listaComenzi = new ArrayList<>();
        this.cardFidelitate = new CardFidelitate();
    }

    protected String getEmail(){return this.email;}
    protected String getParola(){return this.parola;}
    protected CardFidelitate getCardFidelitate() {return this.cardFidelitate;} 
    public List<AdresaLivrare> getListaAdreseLivrare() {return List.copyOf(listaAdreseLivrare);}
    public List<Comanda> getListaComenzi() {return List.copyOf(listaComenzi);}

    protected void adaugareAdresaLivrare(AdresaLivrare adr){
        this.listaAdreseLivrare.add(adr);
    }

    protected void adaugareComanda(Comanda com){
        this.listaComenzi.add(com);
    }

    protected void adaugareProduseInCardFidelitate(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            if(produs.getCategorieProdus() == CategorieProdus.BOL_POKE || produs.getCategorieProdus() == CategorieProdus.SALATA){
                cardFidelitate.nrProduseIntroduse += en.getValue();
                produs.popularitate += en.getValue();
            }
        }
    }

    protected void eliminaReducereDinCardFidelitateDupaIndice(int indice){
        this.getCardFidelitate().listaReduceri.remove(indice);
    }
}
