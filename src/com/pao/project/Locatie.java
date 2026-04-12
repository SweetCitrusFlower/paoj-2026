package com.pao.project;

import java.util.List;

public class Locatie {
    private final Adresa adresa;
    private final List<Angajat> angajati;
    
    public Locatie(Adresa adresa, List<Angajat> angajati) {
        this.adresa = adresa;
        this.angajati = angajati;
    }
    
    public Adresa getAdresa() {return adresa;}
    public List<Angajat> getAngajati() {return List.copyOf(angajati);}
}
