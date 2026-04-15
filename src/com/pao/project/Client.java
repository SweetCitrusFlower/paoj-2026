package com.pao.project;

import com.pao.project.comparators.ComparatorProduseNume;
import com.pao.project.comparators.ComparatorProdusePopularitate;
import com.pao.project.enums.CategorieProdus;
import com.pao.project.enums.Produs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client extends Persoana{
        
    private class CardFidelitate {
        private int nrProduseIntroduse;
        private List<Reducere> listaReduceri;

        public CardFidelitate() {
            this.nrProduseIntroduse = 0;
            this.listaReduceri = new ArrayList<>();
            this.listaReduceri.add(
                new Reducere("Aplica o reducere de 10% la toate produsele din comanda!",
                    (Comanda com) -> {
                        for(Produs pr : com.getProduseCantitate().keySet()){
                            pr.setDiscountProcent(10);    
                        }
                        return com;
                    })
                );
        }
    }

    private final String parola;
    private final CardFidelitate cardFidelitate;
    private final List<AdresaLivrare> listaAdreseLivrare;
    private final List<Comanda> listaComenzi;

    public Client(String nume, String prenume, String nrTelefon, String parola) {
        super(nume, prenume, nrTelefon);
        this.parola = parola;
        this.listaAdreseLivrare = new ArrayList<>();
        this.listaComenzi = new ArrayList<>();
        this.cardFidelitate = new CardFidelitate();
    }

    public String getParola(){return this.parola;}
    public int getNrProduseIntroduse() {return this.cardFidelitate.nrProduseIntroduse;}
    public List<Reducere> getListaReduceri() {return List.copyOf(cardFidelitate.listaReduceri);}
    public List<AdresaLivrare> getListaAdreseLivrare() {return List.copyOf(listaAdreseLivrare);}
    public List<Comanda> getListaComenzi() {return List.copyOf(listaComenzi);}


    private void afisareReduceri(){
        if(this.cardFidelitate.listaReduceri.isEmpty()){
            System.out.println("Nu aveti nicio reducere valabila");
            return;
        }
        int i = 0;
        for(Reducere red : this.cardFidelitate.listaReduceri){
            System.out.println(++i + ". " + red.getDescriere());
        }
    }

    public void AdaugareProduseInCardFidelitate(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            if(produs.getCategorieProdus() == CategorieProdus.BOL_POKE || produs.getCategorieProdus() == CategorieProdus.SALATA){
                cardFidelitate.nrProduseIntroduse += en.getValue();
                produs.popularitate += en.getValue();
            }
        }
    }   

    private void afisareAdrese(){
        if(this.listaAdreseLivrare.isEmpty()){
            System.out.println("Nu aveti nicio adresa de livrare");
            return;
        }
        int i = 0;
        for(AdresaLivrare adr : this.listaAdreseLivrare){
            System.out.println(++i + ". " + adr.toString());
        }
    }

    private void stergereAdresa(Scanner sc){
        System.out.println("Ce adresa doriti sa stergeti? (1 - " + listaAdreseLivrare.size() + "): ");
        try {
            int ind = Integer.parseInt(sc.next().strip());
            this.listaAdreseLivrare.remove(ind - 1);
            System.out.println("Adresa nr. " + ind + " a fost stearsa.");
        } catch (NumberFormatException e) {
            System.out.println("Va rog introduceti un numar intre 1 si " + listaAdreseLivrare.size() + ".");
        }
    }

    private void adaugareAdresa(Scanner sc){
        System.out.print("Numele strazii: ");
        String numeStrada = sc.next().replace("\r", "");
        System.out.print("Nr. strazii: ");
        int nrStrada = Integer.parseInt(sc.next().strip().toLowerCase());
        System.out.print("Nr. apartamentului: ");
        int nrApartament = Integer.parseInt(sc.next().strip().toLowerCase());
        System.out.print("Cod Postal: ");
        int codPostal = Integer.parseInt(sc.next().strip().toLowerCase());
        
        this.listaAdreseLivrare.add(new AdresaLivrare(numeStrada, nrStrada, codPostal, nrApartament));
        
        System.out.println("Noua adresa a fost adaugata!");
    }

    private void afisareIstoricComenzi(){
        if(this.listaComenzi.isEmpty()){
            System.out.println("Nu aveti nicio comanda plasata");
        }
        int i = 0;
        for(Comanda com : this.listaComenzi){
            int nrTotalProduse = 0;
            for(Map.Entry<Produs, Integer> pc : com.getProduseCantitate().entrySet()){
                nrTotalProduse += pc.getValue();
            }
            System.out.println("Comanda nr. " + (++i) + ": " + nrTotalProduse + " produse comandate, plasata la " + com.getDataPlasare() + ", cu adresa de livrare \"" + com.getAdresaLivrare().toString() + '"');
        }
    }

    private void plasareComanda(Scanner sc){

    }

    private void afisareProduseCuComparator(Comparator<Produs> comp){
        Produs[] listaNoua = Produs.values();
        Arrays.sort(listaNoua, comp);
        int i = 0;
        for(Produs pr : listaNoua){
            System.out.println(++i + ". " + pr.toString());
        }
    }

    private void afisareProduse(Scanner sc){
        System.out.println("Alegeti criteriul:");
        System.out.println("1. alfabetic");
        System.out.println("2. dupa popularitate");
        System.out.println("_. dupa pret");
        System.out.print("> ");
        switch(sc.next().strip()){
            case "1" -> {
                afisareProduseCuComparator(new ComparatorProduseNume());
            }
            case "2" -> {
                afisareProduseCuComparator(new ComparatorProdusePopularitate());
            }
            default -> {
                afisareProduseCuComparator(null);
            }
        }
    }
    
    protected void ClientMenu(Scanner sc){
        System.out.println("1. plaseaza o comanda");
        System.out.println("2. afiseaza produsele");
        System.out.println("3. afiseaza reducerile tale");
        System.out.println("4. afiseaza adresele tale de livrare");
        System.out.println("5. adauga o adresa de livrare");
        System.out.println("6. sterge o adresa de livrare");
        System.out.println("7. afiseaza istoricul comenzilor tale");
        System.out.println("_. delogare");
        
        while(true){
            System.out.print("> ");
            switch(sc.next().strip()){
                case "1" -> {
                    plasareComanda(sc);
                }
                case "2" -> {
                    afisareProduse(sc);
                }
                case "3" -> {
                    afisareReduceri();
                }
                case "4" -> {
                    afisareAdrese();
                }
                case "5" -> {
                    adaugareAdresa(sc);
                }
                case "6" -> {
                    afisareAdrese();
                    stergereAdresa(sc);
                }
                case "7" -> {
                    afisareIstoricComenzi();
                }
                default -> {
                    System.out.println("Ne-a parut bine!");
                    return;
                }
            }
            System.out.println();
        }    
    }
}
