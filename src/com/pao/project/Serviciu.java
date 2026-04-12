package com.pao.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serviciu {

    private static class InstanceHolder {
        public static Serviciu instance = new Serviciu();
        public static final List<Client> listaClienti = new ArrayList<>();
        public static final List<Angajat> listaAngajati= new ArrayList<>();
        public static final List<Produs> Meniu = new ArrayList<>();
    }

    private Serviciu(){}

    public static Serviciu getInstance() { return InstanceHolder.instance;}

    public void adaugaProdusMeniu(Produs produs){InstanceHolder.Meniu.add(produs);}
    public void stergeProdusMeniu(int indice){InstanceHolder.Meniu.remove(indice);}
    public void marireSalariuAngajat(int indiceAngajat, int procent){InstanceHolder.listaAngajati.get(indiceAngajat).marireSalariu(procent);}

    
    public void run(){
        try(Scanner sc = new Scanner(System.in)){
            boolean runningMainLoop = true;
            while(runningMainLoop){
                System.out.println("1. logare client");
                System.out.println("2. logare admin");
                System.out.println("_. iesire din aplicatie");
                System.out.print("> ");
                switch(sc.next().strip()){
                    case "1" -> {
                        System.out.print("Aveti cont? (Y/N)\n> ");
                        switch(sc.next().strip().toLowerCase()){
                            case "y" -> {
                                System.out.print("Nume: ");
                                String nume = sc.next().strip().toLowerCase();
                                System.out.print("Prenume: ");
                                String prenume = sc.next().strip().toLowerCase();
                                System.out.print("parola: ");
                                String parola = sc.next().strip().toLowerCase();
                                for (Client cl : Serviciu.InstanceHolder.listaClienti) {
                                    if(cl.getNume().compareTo(nume) == 0 && cl.getPrenume().compareTo(prenume) == 0 && cl.getParola().compareTo(parola) == 0){
                                        System.out.println("Buna, " + prenume + "!");
                                        Serviciu.getInstance().ClientMenu(cl);
                                    }
                                }
                                System.out.println("parola sau numele sunt gresite :(");
                            }
                            default -> {
                                System.out.println("Deci 'nu', ok. Hai sa iti facem un cont!");
                                System.out.print("Nume: ");
                                String nume = sc.next().strip().toLowerCase();
                                System.out.print("Prenume: ");
                                String prenume = sc.next().strip().toLowerCase();
                                for (Client cl : Serviciu.InstanceHolder.listaClienti) {
                                    if(cl.getNume().compareTo(nume) == 0 && cl.getPrenume().compareTo(prenume) == 0){
                                        System.out.println("Aceasta combinatie de nume si prenume exista deja :/");
                                        break;
                                    }
                                }
                                System.out.print("Numar de telefon: ");
                                String nrTelefon = sc.next().strip().toLowerCase();
                                System.out.print("parola: ");
                                String parola = sc.next().strip().toLowerCase();
                                
                                Client cl = new Client(nume, prenume, nrTelefon, parola);
                                Serviciu.InstanceHolder.listaClienti.add(cl);
                                
                                System.out.println("Bine ai venit la noi, " + prenume + "!");
                                Serviciu.getInstance().ClientMenu(cl);
                            }
                        }
                    }
                    case "2" -> {
                        System.out.print("Nume: ");
                        String nume = sc.next().strip().toLowerCase();
                        System.out.print("Prenume: ");
                        String prenume = sc.next().strip().toLowerCase();
                        if(nume.compareTo("AdMiNpOkE") != 0 || prenume.compareTo("PAROLApoke2005!@!@!@") == 0){
                            System.out.println("Logat ca admin cu succes!");
                            Serviciu.getInstance().AdminMenu();
                        }            
                    }
                    default -> {
                        System.out.println("Bye bye!");        
                        runningMainLoop = false; 
                    }
                }
            }
        }
    }

    private void AdminMenu(){

    }

    private void ClientMenu(Client client){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("1. plaseaza o comanda");
            System.out.println("2. afiseaza produsele");
            System.out.println("3. afiseaza reducerile tale");
            System.out.println("4. afiseaza adresele tale de livrare");
            System.out.println("5. adauga o adresa de livrare");
            System.out.println("6. sterge o adresa de livrare");
            System.out.println("7. afiseaza istoricul comenzilor tale");
            System.out.println("_. delogare");
            System.out.print("> ");

            boolean ClientMenuLoopRunning = true;
            while(ClientMenuLoopRunning){
                switch(sc.next().strip()){
                    case "1" -> {
                        // plasare comanda
                    }
                    case "2" -> {
                        // afisare produse
                        //    -> toate / doar cele disponibile
                        //          -> dintr-o categorie anume / sortate dupa un criteriu
                    }
                    case "3" -> {
                        // afiseaza reducerile
                    }
                    case "4" -> {
                        // afiseaza adresele
                    }
                    case "5" -> {
                        //adauga o adresa
                    }
                    case "6" -> {
                        //sterge o adresa
                    }
                    case "7" -> {
                        // istoricul comenzilor
                    }
                    default -> {
                        System.out.println("Ne-a parut bine!");
                        ClientMenuLoopRunning = false;
                    }
                }
            }    
        }
    }
}
