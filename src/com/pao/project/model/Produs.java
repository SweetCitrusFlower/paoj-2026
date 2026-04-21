package com.pao.project.model;

import java.util.List;

public class Produs{

    private final String denumire;
    private final double pret;
    private final CategorieProdus categorieProdus;
    private final List<Ingredient> listaIngrediente;
    private double discountProcent;
    public int popularitate;
    
    public Produs(String denumire, double pret, CategorieProdus categorieProdus, List<Ingredient> listaIngrediente) {
        this.denumire = denumire;
        this.pret = pret;
        this.categorieProdus = categorieProdus;
        this.listaIngrediente = listaIngrediente;
        this.popularitate = 0;
    }

    public String getDenumire() {return denumire;}
    public double getPret() {return pret;}
    public CategorieProdus getCategorieProdus() {return categorieProdus;}
    public List<Ingredient> getListaIngrediente() {return List.copyOf(listaIngrediente);}
    public double getDiscountProcent() {return discountProcent;}
    public int getpopularitate() {return popularitate;}

    public void setDiscountProcent(double discount){this.discountProcent = discount;}

    public boolean esteDisponibil(){
        for(Ingredient i : listaIngrediente){
            if(i.getStoc() <= 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString(){
        String string = this.denumire + " - " + this.categorieProdus.toString() + ", " + this.pret + " lei";
        if(this.esteDisponibil()){
            string += " (" + this.popularitate + " popularitate)";
        }
        else{
            string += " (INDISPONIBIL)";
        }
        return string;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((denumire == null) ? 0 : denumire.hashCode());
        long temp;
        temp = Double.doubleToLongBits(pret);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((categorieProdus == null) ? 0 : categorieProdus.hashCode());
        result = prime * result + ((listaIngrediente == null) ? 0 : listaIngrediente.hashCode());
        temp = Double.doubleToLongBits(discountProcent);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + popularitate;
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
        Produs other = (Produs) obj;
        if (denumire == null) {
            if (other.denumire != null)
                return false;
        } else if (!denumire.equals(other.denumire))
            return false;
        if (Double.doubleToLongBits(pret) != Double.doubleToLongBits(other.pret))
            return false;
        if (categorieProdus != other.categorieProdus)
            return false;
        if (listaIngrediente == null) {
            if (other.listaIngrediente != null)
                return false;
        } else if (!listaIngrediente.equals(other.listaIngrediente))
            return false;
        if (Double.doubleToLongBits(discountProcent) != Double.doubleToLongBits(other.discountProcent))
            return false;
        return popularitate == other.popularitate;
    }
}
