package com.pao.project;

import com.pao.project.enums.CategorieProdus;
import java.util.List;

public class Produs implements Comparable<Produs>{
    private final String denumire;
    private final double pret;
    private final CategorieProdus categorieProdus;
    private final List<Ingredient> listaIngrediente;
    
    public int cntComandat;
    
    public Produs(String denumire, double pret, CategorieProdus categorieProdus, List<Ingredient> listaIngrediente) {
        this.denumire = denumire;
        this.pret = pret;
        this.categorieProdus = categorieProdus;
        this.listaIngrediente = listaIngrediente;
        this.cntComandat = 0;
    }

    public String getDenumire() {return denumire;}
    public double getPret() {return pret;}
    public CategorieProdus getCategorieProdus() {return categorieProdus;}
    public List<Ingredient> getListaIngrediente() {return List.copyOf(listaIngrediente);}

    public boolean esteDisponibil(){
        for(Ingredient i : listaIngrediente){
            if(i.getStoc() <= 0)
                return false;
        }
        return true;
    }

    @Override
    public int compareTo(Produs o) {
        return Double.compare(this.pret, o.getPret());        
    }
}
