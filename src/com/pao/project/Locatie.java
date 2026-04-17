package com.pao.project;

import java.util.List;

public class Locatie extends Adresa{
    private final List<Angajat> angajati;
    
    public Locatie(String numeStrada, int nrStrada, int codPostal, List<Angajat> angajati) {
        super(numeStrada, nrStrada, codPostal);
        this.angajati = angajati;
    }
    
    public List<Angajat> getAngajati() {return List.copyOf(angajati);}

    @Override
    public String toString(){
        return "Strada '" + this.getNumeStrada() + "', nr. " + this.getNrStrada();
    } 
}
