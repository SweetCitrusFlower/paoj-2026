package com.pao.project.model;

import com.pao.project.exception.CategoriaNuExistaException;

public enum CategorieIngredient {
    BAZA, GREEN, PROTEINA, DRESSING, TOPPING, DESERT;

    public static CategorieIngredient getCategorieIngredientString(String str){
        switch(str.toUpperCase()){
            case "BAZA" -> {return CategorieIngredient.BAZA;}
            case "GREEN" -> {return CategorieIngredient.GREEN;}
            case "PROTEINA" -> {return CategorieIngredient.PROTEINA;}
            case "DRESSING" -> {return CategorieIngredient.DRESSING;}
            case "TOPPING" -> {return CategorieIngredient.TOPPING;}
            case "DESERT" -> {return CategorieIngredient.DESERT;}
            default -> {throw new CategoriaNuExistaException();}
        }
    }
}
