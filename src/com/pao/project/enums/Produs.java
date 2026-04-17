package com.pao.project.enums;

import java.util.ArrayList;
import java.util.List;

public enum Produs{
    VEGETARIAN("Vegetarian", 45.9, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_BASMATTI, Ingredient.AVOCADO, Ingredient.ROSII_CHERRY, Ingredient.CASTRAVETI, Ingredient.MASLINE, Ingredient.HUMUS_PICANT, Ingredient.MINT_AND_BASIL, Ingredient.MIGDALE))),
    CHICKEN("Chicken", 46.9, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_ALB, Ingredient.PUI_TERIYAKI, Ingredient.DOVLECEI, Ingredient.ROSII_CHERRY, Ingredient.VARZA_ROSIE, Ingredient.TERIYAKI, Ingredient.SPICY_MAYO, Ingredient.CEAPA_VERDE, Ingredient.MIGDALE, Ingredient.SEMINTE_DE_SUSAN))),
    SHRIMP("Shrimp", 46.9, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_ALB, Ingredient.CREVETI, Ingredient.MANGO, Ingredient.CASTRAVETI, Ingredient.ROSII_CHERRY, Ingredient.SPECIAL, Ingredient.SPICY_MAYO, Ingredient.ALGE_NORI, Ingredient.SEMINTE_DE_SUSAN))),
    SPICY_TUNA("Spicy tuna", 47.99, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_ALB, Ingredient.TON, Ingredient.WAKAME, Ingredient.VARZA_ROSIE, Ingredient.MORCOVI, Ingredient.CASTRAVETI, Ingredient.PONZU, Ingredient.SPICY_PEANUTS, Ingredient.ARDEI_IUTE, Ingredient.CEAPA_CRISPY, Ingredient.SEMINTE_DE_SUSAN))),
    SUNNY_SALMON("Sunny salmon", 47.99, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_ALB, Ingredient.SOMON_JUICY, Ingredient.AVOCADO, Ingredient.EDAMAME, Ingredient.VARZA_ROSIE, Ingredient.SPECIAL, Ingredient.AVOCADO_CREAM, Ingredient.SEMINTE_DE_SUSAN))),
    HOT_AND_SPICY("Hot & spicy", 53.99, CategorieProdus.BOL_POKE, new ArrayList<Ingredient>(List.of(Ingredient.OREZ_ALB, Ingredient.SOMON_SRIRACHA, Ingredient.AVOCADO, Ingredient.EDAMAME, Ingredient.ARDEI_IUTE, Ingredient.SRIRACHA_DRIZZLE, Ingredient.CEAPA_CRISPY, Ingredient.SEMINTE_DE_SUSAN, Ingredient.LIME))),
    
    TRUFFLE_UMAMI("Truffle umami", 54.99, CategorieProdus.SALATA, new ArrayList<Ingredient>(List.of(Ingredient.BABY_SPANAC, Ingredient.ULEI_EVO, Ingredient.MORCOVI_CU_SUSAN_SI_SOIA, Ingredient.FULGI_DE_GRANA_PADANO, Ingredient.CIUPERCI, Ingredient.CEAPA_ROSIE_MURATA, Ingredient.PUI_SLOW_COOKED, Ingredient.TRUFFLE_MAYO))),
    VELVET_GARDEN("Velvet garden", 54.99, CategorieProdus.SALATA, new ArrayList<Ingredient>(List.of(Ingredient.SALATA_ICEBERG, Ingredient.BALSAMIC_VINAIGRETTE, Ingredient.MORCOVI_CU_SUSAN_SI_SOIA, Ingredient.SFECLA_ROSIE_MURATA, Ingredient.MASLINE, Ingredient.CEAPA_ROSIE_MURATA, Ingredient.BRANZA_TELEMEA, Ingredient.MINT_AND_BASIL))),
    THE_CAESAR("The caesar", 59.99, CategorieProdus.SALATA, new ArrayList<Ingredient>(List.of(Ingredient.SALATA_ICEBERG, Ingredient.BALSAMIC_VINAIGRETTE, Ingredient.ROSII_CHERRY, Ingredient.FULGI_DE_GRANA_PADANO, Ingredient.PUI_SLOW_COOKED, Ingredient.BACON, Ingredient.CRUTOANE, Ingredient.CREAMY_CAESAR, Ingredient.LIME))),
    CHICKEN_VIETNAMITA("Chicken vietnamita", 64.99, CategorieProdus.SALATA, new ArrayList<Ingredient>(List.of(Ingredient.BABY_SPANAC, Ingredient.ULEI_EVO_SI_LIME, Ingredient.COCONUT_BASMATTI, Ingredient.CARTOFI_DULCI_CU_ROZMARIN, Ingredient.BROCCOLI_CU_CHILLI_SI_LIME, Ingredient.VARZA_ROSIE, Ingredient.DOVLECEI, Ingredient.PUI_VIETNAMEZ, Ingredient.SOIA_FARA_GLUTEN))),
    EXOTIC_SALMON("Exotic salmon", 64.99, CategorieProdus.SALATA, new ArrayList<Ingredient>(List.of(Ingredient.BABY_SPANAC, Ingredient.ULEI_EVO_SI_LIME, Ingredient.COCONUT_BASMATTI, Ingredient.CARTOFI_DULCI_CU_ROZMARIN, Ingredient.BROCCOLI_CU_CHILLI_SI_LIME, Ingredient.AVOCADO, Ingredient.SOMON_LA_GRATAR, Ingredient.WASABI_MAYO))),
    
    HUMMUS_SI_CRUTOANE("Hummus si crutoane", 16.9, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.HUMUS_PICANT, Ingredient.CRUTOANE))),
    OUA_SI_SPANAC("Oua si spanac", 18.9, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.OU_FIERT, Ingredient.BABY_SPANAC))),
    MEDITERANEANA("Salata mediteraneana", 16.9, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.ROSII_CHERRY, Ingredient.CASTRAVETI, Ingredient.BRANZA_TELEMEA, Ingredient.ULEI_EVO))),
    CARTOFI_DULCI_SI_MAIONEZA("Cartofi dulci cu maioneza", 22.99, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.CARTOFI_DULCI_CU_ROZMARIN, Ingredient.HOUSE_MAYO))),
    WASABI_PEAS("Mazare Wasabi", 18.9, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.WASABI_PEAS))),
    EDAMAME("Edamame", 16.9, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.EDAMAME))),
    GOMA_WAKAME("Alge Goma Wakame", 22.99, CategorieProdus.GARNITURA, new ArrayList<Ingredient>(List.of(Ingredient.WAKAME))),

    TIRAMISU("Tiramisu",24.99, CategorieProdus.DESERT, new ArrayList<Ingredient>(List.of(Ingredient.TIRAMISU))),
    BROWNIE("Brownie",15.9, CategorieProdus.DESERT, new ArrayList<Ingredient>(List.of(Ingredient.BROWNIE))),
    MOCHI("Mochi",14.99, CategorieProdus.DESERT, new ArrayList<Ingredient>(List.of(Ingredient.MOCHI))),
    MINI_FRUIT_BOWL("Mini bol cu fructe",19.50, CategorieProdus.DESERT, new ArrayList<Ingredient>(List.of(Ingredient.MANGO, Ingredient.LIME)))
    ;

    private final String denumire;
    private final double pret;
    private final CategorieProdus categorieProdus;
    private final List<Ingredient> listaIngrediente;
    private double discountProcent;
    public int popularitate;
    
    Produs(String denumire, double pret, CategorieProdus categorieProdus, List<Ingredient> listaIngrediente) {
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
}
