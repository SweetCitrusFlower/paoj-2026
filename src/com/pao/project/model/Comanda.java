package com.pao.project.model;

import java.time.LocalDateTime;
import java.util.Map;

public record Comanda(AdresaLivrare adresaLivrare, Map<Produs, Integer> produseCantitate, Curier curier, Locatie locatie, LocalDateTime dataPlasare) {

    public Comanda(AdresaLivrare adresaLivrare, Map<Produs, Integer> produseCantitate, Curier curier, Locatie locatie, LocalDateTime dataPlasare) {
        this.curier = curier;
        this.locatie = locatie;
        this.adresaLivrare = adresaLivrare;
        this.produseCantitate = produseCantitate;
        this.dataPlasare = LocalDateTime.now();
    }

    public Map<Produs, Integer> getProduseCantitate() {return Map.copyOf(produseCantitate);}
    public LocalDateTime getDataPlasare() {return dataPlasare;}
    public Curier getCurier() {return curier;}
    public Locatie getLocatie() {return locatie;}
    public AdresaLivrare getAdresaLivrare() {return adresaLivrare;}

}
