package com.pao.project.model;

import java.util.ArrayList;
import java.util.List;

public class Locatie extends Adresa{
    private List<Angajat> angajati = new ArrayList<>();
    
    public Locatie(String numeStrada, int nrStrada, int codPostal, int nrApartament, List<Angajat> angajati) {
        super(numeStrada, nrStrada, codPostal, nrApartament);
        this.angajati = angajati;
    }

    public List<Angajat> getAngajati() {return angajati;}
    
    public void addAngajat(Angajat ang) {this.angajati.add(ang);}

    @Override
    public String toString(){
        return "Strada '" + this.getNumeStrada() + "', nr. " + this.getNrStrada();
    } 
}
