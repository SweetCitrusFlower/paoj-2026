package com.pao.laboratory06.exercise3;

import java.util.Optional;

public abstract class Persoana {
    String nume;
    String prenume;
    Optional<String> telefon;
    
    public Persoana(String nume, String prenume, Optional<String> telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Optional<String> getTelefon() {
        return telefon;
    }
}
