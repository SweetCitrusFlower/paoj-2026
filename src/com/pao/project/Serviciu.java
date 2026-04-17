package com.pao.project;

import com.pao.project.comparators.ComparatorProduseNume;
import com.pao.project.comparators.ComparatorProdusePopularitate;
import com.pao.project.comparators.ComparatorProdusePret;
import com.pao.project.enums.CategorieProdus;
import com.pao.project.enums.Ingredient;
import com.pao.project.enums.Produs;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Serviciu {

    private static class InstanceHolder {
        public static Serviciu instance = new Serviciu();
        public static final List<Client> listaClienti = new ArrayList<>();
        public static final List<Locatie> listaLocatii = new ArrayList<>();
    }

    private Serviciu(){}

    private void seedData(){
        Client AlexHancu = new Client("Hancu", "Alexandru", "0756462847", "alexhancu49@gmail.com","parola123");

        Angajat MihaelaCurteanu = new Angajat("Curteanu", "Mihaela", "0765845361", 4200);
        Angajat IoanaRusu = new Angajat("Rusu", "Ioana", "0707986754", 2168);
        Angajat Adriana = new Angajat("Adriana", "Adriana", "0769696969", 4200);
        Angajat Iasmina = new Angajat("Jasmine", "Iasmina", "0765432111", 4000);

        Angajat Illia = new Curier("Savitski", "Illia", "37087875425", 4700);
        Angajat Sofian = new Curier("Giuroiu", "Sofian", "0765879765", 99999);

        Locatie Brezoianu = new Locatie("Ion Brezoianu", 24, 140020, List.of(IoanaRusu, Adriana, Sofian));
        Locatie ParkLake = new Locatie("Park Lake", 1, 123456, List.of(MihaelaCurteanu, Iasmina, Illia));


        InstanceHolder.listaClienti.add(AlexHancu);

        InstanceHolder.listaLocatii.add(Brezoianu);
        InstanceHolder.listaLocatii.add(ParkLake);
    }

    public static Serviciu getInstance() { return InstanceHolder.instance;}
    public static List<Locatie> getLocatii() {return List.copyOf(InstanceHolder.listaLocatii);}

    public void run(){
        seedData();

        try(Scanner sc = new Scanner(System.in).useDelimiter( "\\n");){
            boolean loopedAlready = false;
            while(true){
                if(!loopedAlready){
                    System.out.print("1. logare client\n");
                    System.out.print("_. iesire din aplicatie\n");
                    System.out.print("> ");
                    loopedAlready = true;
                }
                switch(sc.nextLine().strip()){
                    case "1" -> {
                        System.out.print("email: ");
                        String email = sc.next().strip();
                        System.out.print("parola: ");
                        String parola = sc.next().strip();
                        boolean gasitUser = false;
                        for (Client cl : Serviciu.InstanceHolder.listaClienti) {
                            if(cl.getEmail().toLowerCase().compareTo(email.toLowerCase()) == 0 && 
                            cl.getParola().compareTo(parola) == 0){
                                System.out.println("Bine ai revenit, " + cl.getPrenume() + "!");
                                ClientMenu(sc, cl);
                                gasitUser = true;
                            }
                        }
                        if(!gasitUser){
                            System.out.println("Observam ca nu aveti cont. Haideti sa va facem unul!");
                                
                            System.out.print("Nume: ");
                            String nume = sc.next().strip();
                            System.out.print("Prenume: ");
                            String prenume = sc.next().strip();
                            System.out.print("Numar de telefon: ");
                            String nrTelefon = sc.next().strip().toLowerCase();
                            System.out.print("email: ");
                            email = sc.next().strip();
                            System.out.print("parola: ");
                            parola = sc.next().strip();

                            Client cl = new Client(nume, prenume, nrTelefon, email, parola);
                            Serviciu.InstanceHolder.listaClienti.add(cl);
                            
                            System.out.println("Bun venit la noi, " + cl.getPrenume() + "!");
                            ClientMenu(sc, cl);
                        }
                    }
                    case "" -> {
                        loopedAlready = false;
                    }
                    default -> {
                        System.out.println("Bye bye!");
                        System.out.flush();
                        return;
                    }
                }
            }
        }
    }

    private void ajustareStocuriIngrediente(Comanda comanda){
        for (Map.Entry<Produs, Integer> en : comanda.getProduseCantitate().entrySet()) {
            Produs produs = en.getKey();
            for(Ingredient ing : produs.getListaIngrediente()){
                ing.setStoc(ing.getStoc() - en.getValue());
            }
        }
    }
    
    private void plasareComanda(Scanner sc, Client cl){
        if(cl.getListaAdreseLivrare().isEmpty()){
            System.out.println("Se pare ca nu aveti nicio adresa de livrare, asa ca va trbui sa introduceti una");
            adaugareAdresa(sc, cl);
        }

        System.out.println("Alegeti o locatie din ale noastre de unde sa comandati:");
        int i = 0;
        for(Locatie loc : Serviciu.getLocatii()){
            System.out.println((++i) + ". " + loc.toString());
        }
        System.out.print("> ");
        Locatie locatieAleasa = Serviciu.getLocatii().get(Integer.parseInt(sc.next().strip().toLowerCase()) - 1);
        
        Map<Produs, Integer> map = new HashMap<>();
        boolean keepShopping;
        do {
            afisareProduseCuComparator((Arrays.asList(CategorieProdus.values()))
                                        .stream()
                                        .collect(Collectors.toSet()), null, true);
            System.out.print("Introduceti indicele produsului si cantitatea dorita: ");
            String[] tokens = sc.next().strip().split(" ");
            Produs pr = Produs.values()[Integer.parseInt(tokens[0]) - 1];
            int cantitate = Integer.parseInt(tokens[1]);
            if(!pr.esteDisponibil()){
                System.out.println("Produsul este indisponibil");
            }
            else{
                if(cantitate > 0)
                    map.put(pr, cantitate);
            }
            System.out.print("Doriti sa mai cumparati ceva? (y/n): ");
            keepShopping = (sc.next().strip().toLowerCase().compareTo("y") == 0);
        } while (keepShopping);

        if(map.isEmpty()){
            System.out.println("Comanda este goala. Ne pare rau ca nu va place NIMIC!!!!!!!!!!!!!");
            return;
        }

        System.out.println("Alegeti o adresa de livrare:");
        afisareAdrese(cl);
        System.out.print("> ");
        AdresaLivrare adrLivr = cl.getListaAdreseLivrare().get(Integer.parseInt(sc.next().strip()) - 1);

        Random r = new Random();
        List<Angajat> curieriLocatie = locatieAleasa.getAngajati().stream().filter(ang -> ang instanceof Curier).collect(Collectors.toList());
        Comanda com = new Comanda(adrLivr, map, (Curier) curieriLocatie.get(r.nextInt(curieriLocatie.size())), locatieAleasa);
        
        cl.adaugareProduseInCardFidelitate(com);
        ajustareStocuriIngrediente(com);

        if(!cl.getCardFidelitate().getListaReduceri().isEmpty()){
            System.out.println("Aveti reduceri care pot fi aplicate!");
            afisareReduceri(cl);
            System.out.println("Selectati reducerea pe care doriti sa o aplicati.");
            System.out.print("> ");
            int indiceReducere = Integer.parseInt(sc.next().strip().toLowerCase()) - 1;

            cl.getCardFidelitate().getListaReduceri().get(indiceReducere).aplicaReducere(com);
            cl.eliminaReducereDinCardFidelitateDupaIndice(indiceReducere);
        }

        cl.adaugareComanda(com);

        System.out.println("Comanda a fost plasata cu succes!");
    }
    
    private void afisareProduseCuComparator(Set<CategorieProdus> setCat, Comparator<Produs> comp, boolean arataToateProdusele){
        List<Produs> listaProdSort = (Arrays.asList(Produs.values()))
                                .stream()
                                .filter(cat -> setCat.contains(cat.getCategorieProdus()))
                                .filter(cat -> cat.esteDisponibil() || arataToateProdusele)
                                .collect(Collectors.toList());
        if(comp != null)
            listaProdSort.sort(comp);
        int i = 0;
        for(Produs pr : listaProdSort){
            System.out.println(++i + ". " + pr.toString());
        }
    }

    private void afisareProduse(Scanner sc){
        System.out.println("Alegeti categoriile de produse care doriti sa fie afisare:");
        System.out.println("0 (default). Bol Poke");
        System.out.println("1. Salata");
        System.out.println("2. Garnituri");
        System.out.println("3. Deserturi");
        System.out.print("> ");
        
        Set<CategorieProdus> SetCategoriiProdus = new HashSet<>();
        String[] tokens = sc.next().strip().split(" ");
        
        for (String input : tokens) {
            System.out.println(input.getClass());
            CategorieProdus cat;
            switch(input){
                case "1" -> {
                    cat = CategorieProdus.SALATA;
                }
                case "2" -> {
                    cat = CategorieProdus.GARNITURA;
                }
                case "3" -> {
                    cat = CategorieProdus.DESERT;
                }
                default -> {  
                    cat = CategorieProdus.BOL_POKE;
                }
            }
            SetCategoriiProdus.add(cat);
        }


        System.out.println("Alegeti criteriul de sortare:");
        System.out.println("0 (default). dupa pret");
        System.out.println("1. alfabetic");
        System.out.println("2. dupa popularitate");
        System.out.print("> ");
        Comparator<Produs> comp;
        switch(sc.next().strip()){
            case "1" -> {  
                comp = new ComparatorProduseNume();
            }
            case "2" -> {
                comp = new ComparatorProdusePopularitate();
            }
            default -> {
                comp = new ComparatorProdusePret();
            }
        }

        System.out.println("Doriti sa vedeti toate produsele sau doar cele disponibile?");
        System.out.println("0 (default). toate produsele");
        System.out.println("1. doar cele disponibile");
        System.out.print("> ");
        boolean disp;
        switch(sc.next().strip()){
            case "1" -> {  
                disp = false;
            }
            default -> {
                disp = true;
            }
        }
 
        afisareProduseCuComparator(SetCategoriiProdus, comp, disp);
    }

    private void afisareReduceri(Client cl){
        if(cl.getCardFidelitate().getListaReduceri().isEmpty()){
            System.out.println("Nu aveti nicio reducere valabila");
            return;
        }
        int i = 0;
        for(Reducere red : cl.getCardFidelitate().getListaReduceri()){
            System.out.println(++i + ". " + red.getDescriere());
        }
    }

    private void afisareAdrese(Client cl){
        if(cl.getListaAdreseLivrare().isEmpty()){
            System.out.println("Nu aveti nicio adresa de livrare");
            return;
        }
        int i = 0;
        for(AdresaLivrare adr : cl.getListaAdreseLivrare()){
            System.out.println(++i + ". " + adr.toString());
        }
    }

    private void adaugareAdresa(Scanner sc, Client cl){
        System.out.print("Numele strazii: ");
        String numeStrada = sc.next().replace("\r", "");
        System.out.print("Nr. strazii: ");
        int nrStrada = Integer.parseInt(sc.next().strip().toLowerCase());
        System.out.print("Nr. apartamentului: ");
        int nrApartament = Integer.parseInt(sc.next().strip().toLowerCase());
        System.out.print("Cod Postal: ");
        int codPostal = Integer.parseInt(sc.next().strip().toLowerCase());
        
        cl.adaugareAdresaLivrare(new AdresaLivrare(numeStrada, nrStrada, codPostal, nrApartament));
        
        System.out.println("Noua adresa a fost adaugata!");
    }

    private void stergereAdresa(Scanner sc, Client cl){
        afisareAdrese(cl);
        if(cl.getListaAdreseLivrare().isEmpty())
            return;
        System.out.println("Ce adresa doriti sa stergeti? (1 - " + cl.getListaAdreseLivrare().size() + "): ");
        try {
            int ind = Integer.parseInt(sc.next().strip());
            cl.getListaAdreseLivrare().remove(ind - 1);
            System.out.println("Adresa nr. " + ind + " a fost stearsa.");
        } catch (NumberFormatException e) {
            System.out.println("Va rog introduceti un numar intre 1 si " + cl.getListaAdreseLivrare().size() + ".");
        }
    }

    private void afisareIstoricComenzi(Client cl){
        if(cl.getListaComenzi().isEmpty()){
            System.out.println("Nu aveti nicio comanda plasata");
            return;
        }
        int i = 0;
        NumberFormat df = new DecimalFormat("#0.00");
        for(Comanda com : cl.getListaComenzi()){
            int nrTotalProduse = 0;
            int sumaComanda = 0;
            for(Map.Entry<Produs, Integer> pc : com.getProduseCantitate().entrySet()){
                nrTotalProduse += pc.getValue();
                sumaComanda += pc.getValue() * pc.getKey().getPret() * (1 - pc.getKey().getDiscountProcent() / 100);
            }
            System.out.println("Comanda nr. " + (++i) + ": " + nrTotalProduse + " produse, " + df.format(sumaComanda) + " lei, plasata la " + com.getDataPlasare() + ", cu adresa de livrare \"" + com.getAdresaLivrare().toString() + "\", livrata de " + com.getCurier().getNume());
        }
    }
    
    protected void ClientMenu(Scanner sc, Client cl){
        while(true){
            System.out.println("1. plaseaza o comanda");
            System.out.println("2. afiseaza produsele");
            System.out.println("3. verifica cardul de fidelitate");
            System.out.println("4. afiseaza adresele tale de livrare");
            System.out.println("5. adauga o adresa de livrare");
            System.out.println("6. sterge o adresa de livrare");
            System.out.println("7. afiseaza istoricul comenzilor tale");
            System.out.println("_. delogare");    
            System.out.print("> ");
            switch(sc.next().strip()){
                case "1" -> {
                    plasareComanda(sc, cl);
                }
                case "2" -> {
                    afisareProduse(sc);
                }
                case "3" -> {
                    System.out.println("Cardul a inregistrat " + cl.getCardFidelitate().getNrProduseIntroduse() + " boluri!");
                    afisareReduceri(cl);
                }
                case "4" -> {
                    afisareAdrese(cl);
                }
                case "5" -> {
                    adaugareAdresa(sc, cl);
                }
                case "6" -> {
                    stergereAdresa(sc, cl);
                }
                case "7" -> {
                    afisareIstoricComenzi(cl);
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
