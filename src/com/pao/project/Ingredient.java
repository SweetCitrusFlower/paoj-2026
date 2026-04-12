package com.pao.project;

import com.pao.project.enums.CategorieIngredient;

public class Ingredient {
    private final String nume;
    private final CategorieIngredient categorieIngredient;
    private final int stoc;
    
    public Ingredient(String nume, CategorieIngredient categorieIngredient, int stoc) {
        this.nume = nume;
        this.categorieIngredient = categorieIngredient;
        this.stoc = stoc;
    }

    public String getNume() {return nume;}
    public CategorieIngredient getCategorieIngredient() {return categorieIngredient;}
    public int getStoc() {return stoc;}
}
