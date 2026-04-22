package com.pao.project.service;

import com.pao.project.exception.CategoriaNuExistaException;
import com.pao.project.exception.IngredientDejaExistaException;
import com.pao.project.exception.IngredientulNuExista;
import com.pao.project.model.Angajat;
import com.pao.project.model.CategorieIngredient;
import com.pao.project.model.CategorieProdus;
import com.pao.project.model.Client;
import com.pao.project.model.Curier;
import com.pao.project.model.Ingredient;
import com.pao.project.model.Locatie;
import com.pao.project.model.Produs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiciuAdmin {

    private static class InstanceHolder {
        public static ServiciuAdmin instance = new ServiciuAdmin();
    }

    private ServiciuAdmin(){}
    public static ServiciuAdmin getInstance() { return InstanceHolder.instance;}

    protected void run(Scanner sc){
        while(true){
            System.out.println("1. Adaugare ingredient");
            System.out.println("2. Adaugare produs");
            System.out.println("3. Adaugare angajat");
            System.out.println("4. Afisare ingrediente");
            System.out.println("5. Afisare produse");
            System.out.println("6. Afisare angajati");
            System.out.println("7. Afisare clienti");
            System.out.println("out. delogare");    
            System.out.print("> ");
            switch(sc.next().strip()){
                case "1" -> {
                    adaugareIngredient(sc);
                }
                case "2" -> {
                    adaugareProdus(sc);
                }
                case "3" -> {
                    adaugareAngajat(sc);
                }
                case "4" -> {
                    afisareIngrediente();
                }
                case "5" -> {
                    afisareProduse();
                }
                case "6" -> {
                    afisareAngajati();
                }
                case "7" -> {
                    afisareClienti();
                }
                case "out" -> {
                    System.out.println("Adios!");
                    System.out.println();
                    return;
                }
                default -> {
                    System.out.println("Input necunoscut; incercati din nou.");
                }
            }
            System.out.println();
        }    
    }

    protected void adaugareIngredient(Scanner sc){
        while (true) {
            String nume;
            CategorieIngredient cat;
            while (true) { 
                try {
                    System.out.print("Denumire: ");
                    nume = sc.next().strip();
                    for(Ingredient ing : ServiciuPrincipal.getListaIngrediente()){
                        if(ing.getNume().equalsIgnoreCase(nume))
                            throw new IngredientDejaExistaException();
                    }
                    break;
                }catch (IngredientDejaExistaException e) {
                    System.out.println("Ingredientul deja exista; incercati din nou");
                }
            }
            
            while (true) { 
                System.out.print("Categorie: ");
                try {
                    cat = CategorieIngredient.getCategorieIngredientString(sc.next().strip().toUpperCase());
                    break;
                } catch (CategoriaNuExistaException e) {
                    System.out.println("Categoria nu este recunoscuta; incercati din nou");
                }
            }

            System.out.println("Ingredientul \'" + nume + "\' a fost adaugat cu 100 de bucati in stoc!");
            ServiciuPrincipal.addIngredient(new Ingredient(nume, cat, 100));
            break;
        } 
    }

    protected void adaugareProdus(Scanner sc){
        while (true) {
            String nume;
            CategorieProdus cat;
            while (true) { 
                try {
                    System.out.print("Denumire: ");
                    nume = sc.next().strip();
                    for(Produs pr : ServiciuPrincipal.getListaProduse()){
                        if(pr.getDenumire().equalsIgnoreCase(nume))
                            throw new IngredientDejaExistaException();
                    }
                    break;
                }catch (IngredientDejaExistaException e) {
                    System.out.println("Produsul deja exista; incercati din nou");
                }
            }

            System.out.print("Pret: ");
            int pret = Integer.parseInt(sc.next().strip());
            
            while (true) { 
                System.out.print("Categorie: ");
                try {
                    cat = CategorieProdus.getCategorieProdusString(sc.next().strip().toUpperCase());
                    break;
                } catch (CategoriaNuExistaException e) {
                    System.out.println("Categoria nu este recunoscuta; incercati din nou");
                }
            }
            System.out.print("Numar ingrediente: ");
            int nrIngr = Integer.parseInt(sc.next().strip());

            List<Ingredient> lista = new ArrayList<>();
            for(int i = 0; i < nrIngr; i++){
                while (true) {
                    System.out.println("Nume ingredient " + (i + 1) + ": ");
                    try {
                        Ingredient ingr = ServiciuPrincipal.gasesteIngredientDupaNume(sc.next().strip());
                        lista.add(ingr);
                        break;
                    } catch (IngredientulNuExista e) {
                        System.out.println("Ingredientul nu poate fi gasit; incercati din nou");
                    }
                }
            }

            ServiciuPrincipal.addProdus(new Produs(nume, pret, cat, lista));
            System.out.println("Produsul '" + nume + "' a fost adaugat in meniu!");
            break;
        } 
    }

    protected void adaugareAngajat(Scanner sc){
                                
        System.out.print("Nume: ");
        String nume = sc.next().strip();
        System.out.print("Prenume: ");
        String prenume = sc.next().strip();
        System.out.print("Numar de telefon: ");
        String nrTelefon = sc.next().strip().toLowerCase();
        System.out.print("salariu: ");
        double salariu = Double.parseDouble(sc.next().strip());
        
        System.out.println("Selecteaza locatie: ");
        List<Locatie> locatii = ServiciuPrincipal.getListaLocatii();
        for (int idx = 0; idx < locatii.size(); idx++) {
            System.out.println((idx + 1) + ": " + locatii.get(idx).toString());
        }
        int idx = Integer.parseInt(sc.next().strip()) - 1;
        
        Angajat ang;
        System.out.print("Curier? (Y/N): ");
        switch(sc.next().strip().toLowerCase()){
            case "y" -> {
                ang = new Curier(nume, prenume, nrTelefon, salariu);
            }
            default -> {
                ang = new Angajat(nume, prenume, nrTelefon, salariu);
            }
        }

        ServiciuPrincipal.addAngajatSiLocatie(ang, idx);
        
        System.out.println("Noul angajat \'" + prenume + "\'a fost adaugat!");
    }

    private void afisareIngrediente() {
        int i = 0;
        for(Ingredient ingr : ServiciuPrincipal.getListaIngrediente()){
            System.out.println(++i + ". " + ingr.toString());
        }
    }
    
    private void afisareProduse() {
        int i = 0;
        for(Produs pr : ServiciuPrincipal.getListaProduse()){
            System.out.println(++i + ". " + pr.toString());
        }
    }

    private void afisareAngajati() {
        int i = 0;
        for(Angajat ang : ServiciuPrincipal.getListaAngajati()){
            System.out.println(++i + ". " + ang.toString());
        }
    }

    private void afisareClienti() {
        int i = 0;
        for(Client cl : ServiciuPrincipal.getListaClienti()){
            System.out.println(++i + ". " + cl.toString());
        }
    }
}
