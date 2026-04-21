package com.pao.project.model;

import java.util.ArrayList;
import java.util.List;

public class CardFidelitate {
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

    protected void addNrProduseIntroduse(int val) {nrProduseIntroduse += val;}
    protected void removeReducere(int ind){listaReduceri.remove(ind);}
}