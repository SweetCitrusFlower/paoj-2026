package com.pao.project.model;

import com.pao.project.exception.CategoriaNuExistaException;

public enum CategorieProdus {
    BOL_POKE, SALATA, GARNITURA, DESERT;

    public static CategorieProdus getCategorieProdusString(String str){
        switch(str.toUpperCase()){
            case "BOL" -> {return CategorieProdus.BOL_POKE;}
            case "SALATA" -> {return CategorieProdus.SALATA;}
            case "GARNITURA" -> {return CategorieProdus.GARNITURA;}
            case "DESERT" -> {return CategorieProdus.DESERT;}
            default -> {throw new CategoriaNuExistaException();}
        }
    }
}
