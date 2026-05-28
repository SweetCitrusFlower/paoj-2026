package com.pao.project.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Comanda {

    private long id;
    private final Client client;
    private final Angajat curier;
    private final Adresa locatie;
    private final Adresa adresaLivrare;
    private final Map<Produs, Integer> produseCantitate;
    private final LocalDateTime dataPlasare;
    private ComandaStatus status;

    public Comanda(Adresa adresaLivrare, Client client, Map<Produs, Integer> produseCantitate, Angajat curier, Adresa locatie, LocalDateTime dataPlasare) 
    {
        this.curier = curier;
        this.locatie = locatie;
        this.adresaLivrare = adresaLivrare;
        this.client = client;
        this.produseCantitate = produseCantitate;
        this.status = ComandaStatus.PLASATA;
        this.dataPlasare = LocalDateTime.now();
    }

    public Map<Produs, Integer> getProduseCantitate() {return Map.copyOf(produseCantitate);}
    public LocalDateTime getDataPlasare() {return dataPlasare;}
    public Client getClient() {return client;}
    public Angajat getCurier() {return curier;}
    public Adresa getLocatie() {return locatie;}
    public Adresa getAdresaLivrare() {return adresaLivrare;}
    public ComandaStatus getStatus() {return status;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    public void statusNext(){this.status = status.next();}
    public void anulare(){this.status = status.anulare();}



}
