package com.pao.project.model;

import java.util.function.Function;

public class Reducere {
    private final Function<Comanda, Comanda> functie;
    private final String descriere;

    public Reducere(String descriere, Function<Comanda, Comanda> functie) {
        this.functie = functie;
        this.descriere = descriere;
    }

    public String getDescriere() {return descriere;}
    public Comanda aplicaReducere(Comanda com){return functie.apply(com);}
}
