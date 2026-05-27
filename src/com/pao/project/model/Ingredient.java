package com.pao.project.model;

import java.util.Objects;

public class Ingredient {
    private long id;
    private final String nume;
    private final CategorieIngredient categorieIngredient;
    private int stoc;
    
    public Ingredient(String nume, CategorieIngredient categorieIngredient, int stoc) {
        this.nume = nume;
        this.categorieIngredient = categorieIngredient;
        this.stoc = stoc;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    public String getNume() {return nume;}
    public CategorieIngredient getCategorieIngredient() {return categorieIngredient;}
    public int getStoc() {return stoc;}

    public void setStoc(int stocNou) {this.stoc = stocNou;}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nume);
        hash = 47 * hash + Objects.hashCode(this.categorieIngredient);
        hash = 47 * hash + this.stoc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredient other = (Ingredient) obj;
        if (!Objects.equals(this.nume, other.nume)) {
            return false;
        }
        return this.categorieIngredient == other.categorieIngredient;
    }

    @Override
    public String toString(){
        String string = this.nume + " - " + this.categorieIngredient.toString() + " - " + this.stoc + " bucati in stoc";
        return string; 
    }
}
