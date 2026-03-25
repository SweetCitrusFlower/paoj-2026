package com.pao.laboratory05.biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class BibliotecaService {
    private static class InstanceHolder {
        public static BibliotecaService instance = new BibliotecaService();
    }

    private BibliotecaService(){}

    public static BibliotecaService getInstance(){
        return InstanceHolder.instance;
    }

    private Carte[] carti = new Carte[0];
    public void addCarte(Carte carte){
        System.arraycopy(carti, 0, carti = new Carte[carti.length + 1], 0, carti.length - 1);
        carti[carti.length - 1] = carte;
        System.out.println("Carte " + carte.getTitlu() + " adaugata!");
    }

    public void listSortedByRating(){
        Carte[] copy = this.carti.clone();
        Arrays.sort(copy);
        for (Carte Carte : copy) {
            System.out.println(Carte);
        }
    }

    public void listSortedBy(Comparator<Carte> comparator){
        Carte[] copy = this.carti.clone();
        Arrays.sort(copy, comparator);
        for (Carte Carte : copy) {
            System.out.println(Carte);
        }
    }
}
