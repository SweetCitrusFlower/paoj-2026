package com.pao.project;

import com.pao.project.enums.CategorieProdus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CardFidelitate {
    private List<Produs> listaProduseIntroduse;
    private List<Reducere> listaReduceri;

    public CardFidelitate() {
        this.listaProduseIntroduse = new ArrayList<>();
        this.listaReduceri =  new ArrayList<>();
    }

    public List<Produs> getListaProduseIntroduse() {
        return List.copyOf(listaProduseIntroduse);
    }

    public List<Reducere> getListaReduceri() {
        return List.copyOf(listaReduceri);
    }

    public void AdaugareProduse(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            if(produs.getCategorieProdus() == CategorieProdus.BOL_POKE || produs.getCategorieProdus() == CategorieProdus.SALATA){
                for (int i = 0; i < en.getValue(); i++){
                    listaProduseIntroduse.add(produs);
                }
            }
        }
    }
}
