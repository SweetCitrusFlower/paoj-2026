package com.pao.project;

import java.util.ArrayList;
import java.util.List;

public class Serviciu {
    private final List<Client> listaClienti;
    private List<Angajat> listaAngajati;
    private static final List<Produs> Meniu = new ArrayList<>();

    private static class InstanceHolder {
        public static Serviciu instance = new Serviciu();
    }

    private Serviciu(){
        listaClienti = new ArrayList<>();
        listaAngajati = new ArrayList<>();
    }

    public static Serviciu getInstance() { return InstanceHolder.instance;}

    public List<Client> getListaClienti(){return List.copyOf(listaClienti);}
    public List<Angajat> getListaAngajati(){return List.copyOf(listaAngajati);}
    public List<Produs> getMeniu(){return List.copyOf(Meniu);}

    public void adaugaProdusMeniu(Produs produs){
        Serviciu.Meniu.add(produs);
    }

    public void scoateProdusMeniu(int indice){
        Serviciu.Meniu.remove(indice);
    }

    public void marireSalariu(int indiceAngajat, int procent){
        listaAngajati.get(indiceAngajat).marireSalariu(procent);
    }

}
