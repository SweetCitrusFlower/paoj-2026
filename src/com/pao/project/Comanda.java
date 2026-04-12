package com.pao.project;

import com.pao.project.enums.Status;
import java.time.LocalDateTime;
import java.util.Map;

public class Comanda {
    private final Map<Produs, Integer> produseCantitate;
    private final LocalDateTime dataPlasare;
    private Status status;
    private final Curier curier;
    private final Locatie locatie;
    private final AdresaLivrare adresaLivrare;

    public Comanda(AdresaLivrare adresaLivrare, Map<Produs, Integer> produseCantitate, Curier curier, Locatie locatie) {
        this.curier = curier;
        this.locatie = locatie;
        this.adresaLivrare = adresaLivrare;
        this.produseCantitate = produseCantitate;

        this.status = Status.PLASATA;
        this.dataPlasare = LocalDateTime.now();
    }

    public Map<Produs, Integer> getProduseCantitate() {return Map.copyOf(produseCantitate);}
    public LocalDateTime getDataPlasare() {return dataPlasare;}
    public Status getStatus() {return status;}
    public Curier getCurier() {return curier;}
    public Locatie getLocatie() {return locatie;}
    public AdresaLivrare getAdresaLivrare() {return adresaLivrare;}

}
