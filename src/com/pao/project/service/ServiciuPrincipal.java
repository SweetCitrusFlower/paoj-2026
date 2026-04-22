package com.pao.project.service;

import com.pao.project.exception.IngredientDejaExistaException;
import com.pao.project.exception.IngredientulNuExista;
import com.pao.project.model.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiciuPrincipal {

    private static class InstanceHolder {
        public static ServiciuPrincipal instance = new ServiciuPrincipal();
        public static final List<Client> listaClienti = initiereClienti();

        public static final List<Locatie> listaLocatii = new ArrayList<>();
        public static final List<Angajat> listaAngajati = initiereAngajati_setareLocatii();

        public static final List<Produs> listaProduse = new ArrayList<>();
        public static final List<Ingredient> listaIngediente = initiereIngrediente_setareProduse();

        private static List<Client> initiereClienti(){
            List<Client> lista = new ArrayList<>();

            Client AlexHancu = new Client("Hancu", "Alexandru", "0756462847", "alexhancu49@gmail.com","parola123");
            lista.add(AlexHancu);

            return lista;
        }

        private static List<Angajat> initiereAngajati_setareLocatii(){       
            List<Angajat> lista = new ArrayList<>();
            
            Angajat MihaelaCurteanu = new Angajat("Curteanu", "Mihaela", "0765845361", 4200);
            Angajat IoanaRusu = new Angajat("Rusu", "Ioana", "0707986754", 2168);
            Angajat Adriana = new Angajat("Adriana", "Adriana", "0769696969", 4200);
            Angajat Iasmina = new Angajat("Jasmine", "Iasmina", "0765432111", 4000);

            Angajat Illia = new Curier("Savitski", "Illia", "37087875425", 4700);
            Angajat Sofian = new Curier("Giuroiu", "Sofian", "0765879765", 99999);
        
            lista.add(MihaelaCurteanu);
            lista.add(IoanaRusu);
            lista.add(Adriana);
            lista.add(Iasmina);
            lista.add(Illia);
            lista.add(Sofian);
            
            Locatie Brezoianu = new Locatie("Ion Brezoianu", 24, 140020, new ArrayList<>(List.of(IoanaRusu, Adriana, Sofian)));
            Locatie ParkLake = new Locatie("Park Lake", 1, 123456, new ArrayList<>(List.of(MihaelaCurteanu, Iasmina, Illia)));

            InstanceHolder.listaLocatii.add(Brezoianu);
            InstanceHolder.listaLocatii.add(ParkLake);   

            return lista;
        }

        private static List<Ingredient> initiereIngrediente_setareProduse(){
            List<Ingredient> lista = new ArrayList<>();

            Ingredient OREZ_ALB = new Ingredient("Orez alb", CategorieIngredient.BAZA, 100);
            Ingredient OREZ_BRUN = new Ingredient("Orez brun", CategorieIngredient.BAZA, 100);
            Ingredient OREZ_BASMATTI = new Ingredient("Orez basmatti", CategorieIngredient.BAZA, 100);
            Ingredient COCONUT_BASMATTI = new Ingredient("Coconut basmatti", CategorieIngredient.BAZA, 100);
            Ingredient QUINOA = new Ingredient("Quinoa", CategorieIngredient.BAZA, 100);
            Ingredient BABY_SPANAC = new Ingredient("Baby spanac", CategorieIngredient.BAZA, 100);
            Ingredient SALATA_ICEBERG = new Ingredient("Salată iceberg", CategorieIngredient.BAZA, 100);
            Ingredient AVOCADO = new Ingredient("Avocado", CategorieIngredient.GREEN, 100);
            Ingredient MANGO = new Ingredient("Mango", CategorieIngredient.GREEN, 100);
            Ingredient WAKAME = new Ingredient("Alge Goma wakame", CategorieIngredient.GREEN, 100);
            Ingredient FULGI_DE_GRANA_PADANO = new Ingredient("Fulgi de grana padano", CategorieIngredient.GREEN, 100);
            Ingredient CARTOFI_DULCI_CU_ROZMARIN = new Ingredient("Cartofi dulci cu rozmarin", CategorieIngredient.GREEN, 100);
            Ingredient BROCCOLI_CU_CHILLI_SI_LIME = new Ingredient("Broccoli cu chilli și lime", CategorieIngredient.GREEN, 100);
            Ingredient MORCOVI_CU_SUSAN_SI_SOIA = new Ingredient("Morcovi cu susan și soia", CategorieIngredient.GREEN, 100);
            Ingredient MORCOVI = new Ingredient("Morcovi", CategorieIngredient.GREEN, 100);
            Ingredient ROSII_CHERRY = new Ingredient("Roșii cherry", CategorieIngredient.GREEN, 100);
            Ingredient CREMA_DE_BRANZA = new Ingredient("Cremă de brânză", CategorieIngredient.GREEN, 100);
            Ingredient DOVLECEI = new Ingredient("Dovlecei", CategorieIngredient.GREEN, 100);
            Ingredient CASTRAVETI = new Ingredient("Castraveți", CategorieIngredient.GREEN, 100);
            Ingredient EDAMAME = new Ingredient("Edamame", CategorieIngredient.GREEN, 100);
            Ingredient ARDEI_IUTE = new Ingredient("Ardei iute", CategorieIngredient.GREEN, 100);
            Ingredient CIUPERCI = new Ingredient("Ciuperci", CategorieIngredient.GREEN, 100);
            Ingredient MASLINE = new Ingredient("Măsline", CategorieIngredient.GREEN, 100);
            Ingredient SFECLA_ROSIE_MURATA = new Ingredient("Sfeclă roșie murată", CategorieIngredient.GREEN, 100);
            Ingredient GHIMBIR_MURAT = new Ingredient("Ghimbir murat", CategorieIngredient.GREEN, 100);
            Ingredient CEAPA_ROSIE_MURATA = new Ingredient("Ceapă roșie murată", CategorieIngredient.GREEN, 100);
            Ingredient VARZA_ROSIE = new Ingredient("Varză roșie", CategorieIngredient.GREEN, 100);
            Ingredient HUMUS_PICANT = new Ingredient("Humus picant", CategorieIngredient.GREEN, 100);
            Ingredient CEAPA_VERDE = new Ingredient("Ceapă verde", CategorieIngredient.GREEN, 100);
            Ingredient PORUMB_DULCE = new Ingredient("Porumb dulce", CategorieIngredient.GREEN, 100);
            Ingredient BRANZA_TELEMEA = new Ingredient("Branza telemea", CategorieIngredient.GREEN, 100);
            Ingredient SOMON_LA_GRATAR = new Ingredient("Somon la grătar", CategorieIngredient.PROTEINA, 100);
            Ingredient PUI_SLOW_COOKED = new Ingredient("Pui slow cooked", CategorieIngredient.PROTEINA, 100);
            Ingredient PUI_TERIYAKI = new Ingredient("Pui teriyaki", CategorieIngredient.PROTEINA, 100);
            Ingredient PUI_VIETNAMEZ = new Ingredient("Pui vietnamez", CategorieIngredient.PROTEINA, 100);
            Ingredient SOMON_JUICY = new Ingredient("Somon juicy", CategorieIngredient.PROTEINA, 100);
            Ingredient SOMON_SRIRACHA = new Ingredient("Sriracha salmon", CategorieIngredient.PROTEINA, 100);
            Ingredient SOMON_NORWEGIAN = new Ingredient("Somon norwegian", CategorieIngredient.PROTEINA, 100);
            Ingredient OU_FIERT = new Ingredient("Ou fiert", CategorieIngredient.PROTEINA, 100);
            Ingredient CREVETI = new Ingredient("Creveți", CategorieIngredient.PROTEINA, 100);
            Ingredient TON = new Ingredient("Ton", CategorieIngredient.PROTEINA, 100);
            Ingredient TOFU = new Ingredient("Tofu", CategorieIngredient.PROTEINA, 100);
            Ingredient AVOCADO_CREAM = new Ingredient("Avocado cream", CategorieIngredient.DRESSING, 100);
            Ingredient SPICY_PEANUTS = new Ingredient("Spicy peanuts", CategorieIngredient.DRESSING, 100);
            Ingredient CREAMY_CAESAR = new Ingredient("Creamy caesar", CategorieIngredient.DRESSING, 100);
            Ingredient SPICY_MAYO = new Ingredient("Spicy mayo", CategorieIngredient.DRESSING, 100);
            Ingredient WASABI_MAYO = new Ingredient("Wasabi mayo", CategorieIngredient.DRESSING, 100);
            Ingredient HOUSE_MAYO = new Ingredient("House mayo", CategorieIngredient.DRESSING, 100);
            Ingredient TRUFFLE_MAYO = new Ingredient("Truffle mayo", CategorieIngredient.DRESSING, 100);
            Ingredient ULEI_EVO = new Ingredient("Ulei evo", CategorieIngredient.DRESSING, 100);
            Ingredient ULEI_EVO_SI_LIME = new Ingredient("Ulei evo și lime", CategorieIngredient.DRESSING, 100);
            Ingredient MINT_AND_BASIL = new Ingredient("Mint & basil", CategorieIngredient.DRESSING, 100);
            Ingredient SWEET_CHILLI = new Ingredient("Sweet chilli", CategorieIngredient.DRESSING, 100);
            Ingredient SRIRACHA_DRIZZLE = new Ingredient("Sriracha drizzle", CategorieIngredient.DRESSING, 100);
            Ingredient BALSAMIC_VINAIGRETTE = new Ingredient("Balsamic vinaigrette", CategorieIngredient.DRESSING, 100);
            Ingredient SOIA_FARA_GLUTEN = new Ingredient("Soia fără gluten", CategorieIngredient.DRESSING, 100);
            Ingredient PONZU = new Ingredient("Ponzu", CategorieIngredient.DRESSING, 100);
            Ingredient SPECIAL = new Ingredient("Special", CategorieIngredient.DRESSING, 100);
            Ingredient TERIYAKI = new Ingredient("Teriyaki", CategorieIngredient.DRESSING, 100);
            Ingredient MIGDALE = new Ingredient("Migdale", CategorieIngredient.TOPPING, 100);
            Ingredient BACON = new Ingredient("Bacon", CategorieIngredient.TOPPING, 100);
            Ingredient CEAPA_CRISPY = new Ingredient("Ceapă crispy", CategorieIngredient.TOPPING, 100);
            Ingredient CARTOFI_DULCI_CRISPY = new Ingredient("Cartofi dulci crispy", CategorieIngredient.TOPPING, 100);
            Ingredient CRUTOANE = new Ingredient("Crutoane", CategorieIngredient.TOPPING, 100);
            Ingredient ALGE_NORI = new Ingredient("Alge nori", CategorieIngredient.TOPPING, 100);
            Ingredient WASABI_PEAS = new Ingredient("Wasabi peas", CategorieIngredient.TOPPING, 100);
            Ingredient LIME = new Ingredient("Lime", CategorieIngredient.TOPPING, 40);
            Ingredient SEMINTE_DE_SUSAN = new Ingredient("Seminte de susan", CategorieIngredient.TOPPING, 1000);
            Ingredient TIRAMISU = new Ingredient("Tiramisu", CategorieIngredient.DESERT, 30);
            Ingredient BROWNIE = new Ingredient("Brownie", CategorieIngredient.DESERT, 30);
            Ingredient MOCHI = new Ingredient("Mochi", CategorieIngredient.DESERT, 40);
            
            lista.add(OREZ_ALB);
            lista.add(OREZ_BRUN);
            lista.add(OREZ_BASMATTI);
            lista.add(COCONUT_BASMATTI);
            lista.add(QUINOA);
            lista.add(BABY_SPANAC);
            lista.add(SALATA_ICEBERG);
            lista.add(AVOCADO);
            lista.add(MANGO);
            lista.add(WAKAME);
            lista.add(FULGI_DE_GRANA_PADANO);
            lista.add(CARTOFI_DULCI_CU_ROZMARIN);
            lista.add(BROCCOLI_CU_CHILLI_SI_LIME);
            lista.add(MORCOVI_CU_SUSAN_SI_SOIA);
            lista.add(MORCOVI);
            lista.add(ROSII_CHERRY);
            lista.add(CREMA_DE_BRANZA);
            lista.add(DOVLECEI);
            lista.add(CASTRAVETI);
            lista.add(EDAMAME);
            lista.add(ARDEI_IUTE);
            lista.add(CIUPERCI);
            lista.add(MASLINE);
            lista.add(SFECLA_ROSIE_MURATA);
            lista.add(GHIMBIR_MURAT);
            lista.add(CEAPA_ROSIE_MURATA);
            lista.add(VARZA_ROSIE);
            lista.add(HUMUS_PICANT);
            lista.add(CEAPA_VERDE);
            lista.add(PORUMB_DULCE);
            lista.add(BRANZA_TELEMEA);
            lista.add(SOMON_LA_GRATAR);
            lista.add(PUI_SLOW_COOKED);
            lista.add(PUI_TERIYAKI);
            lista.add(PUI_VIETNAMEZ);
            lista.add(SOMON_JUICY);
            lista.add(SOMON_SRIRACHA);
            lista.add(SOMON_NORWEGIAN);
            lista.add(OU_FIERT);
            lista.add(CREVETI);
            lista.add(TON);
            lista.add(TOFU);
            lista.add(AVOCADO_CREAM);
            lista.add(SPICY_PEANUTS);
            lista.add(CREAMY_CAESAR);
            lista.add(SPICY_MAYO);
            lista.add(WASABI_MAYO);
            lista.add(HOUSE_MAYO);
            lista.add(TRUFFLE_MAYO);
            lista.add(ULEI_EVO);
            lista.add(ULEI_EVO_SI_LIME);
            lista.add(MINT_AND_BASIL);
            lista.add(SWEET_CHILLI);
            lista.add(SRIRACHA_DRIZZLE);
            lista.add(BALSAMIC_VINAIGRETTE);
            lista.add(SOIA_FARA_GLUTEN);
            lista.add(PONZU);
            lista.add(SPECIAL);
            lista.add(TERIYAKI);
            lista.add(MIGDALE);
            lista.add(BACON);
            lista.add(CEAPA_CRISPY);
            lista.add(CARTOFI_DULCI_CRISPY);
            lista.add(CRUTOANE);
            lista.add(ALGE_NORI);
            lista.add(WASABI_PEAS);
            lista.add(LIME);
            lista.add(SEMINTE_DE_SUSAN);
            lista.add(TIRAMISU);
            lista.add(BROWNIE);
            lista.add(MOCHI);

            Produs VEGETARIAN = new Produs("Vegetarian", 45.9, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_BASMATTI, AVOCADO, ROSII_CHERRY, CASTRAVETI, MASLINE, HUMUS_PICANT, MINT_AND_BASIL, MIGDALE)));
            Produs CHICKEN = new Produs("Chicken", 46.9, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_ALB, PUI_TERIYAKI, DOVLECEI, ROSII_CHERRY, VARZA_ROSIE, TERIYAKI, SPICY_MAYO, CEAPA_VERDE, MIGDALE, SEMINTE_DE_SUSAN)));
            Produs SHRIMP = new Produs("Shrimp", 46.9, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_ALB, CREVETI, MANGO, CASTRAVETI, ROSII_CHERRY, SPECIAL, SPICY_MAYO, ALGE_NORI, SEMINTE_DE_SUSAN)));
            Produs SPICY_TUNA = new Produs("Spicy tuna", 47.99, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_ALB, TON, WAKAME, VARZA_ROSIE, MORCOVI, CASTRAVETI, PONZU, SPICY_PEANUTS, ARDEI_IUTE, CEAPA_CRISPY, SEMINTE_DE_SUSAN)));
            Produs SUNNY_SALMON = new Produs("Sunny salmon", 47.99, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_ALB, SOMON_JUICY, AVOCADO, EDAMAME, VARZA_ROSIE, SPECIAL, AVOCADO_CREAM, SEMINTE_DE_SUSAN)));
            Produs HOT_AND_SPICY = new Produs("Hot & spicy", 53.99, CategorieProdus.BOL_POKE, new ArrayList<> (List.of(OREZ_ALB, SOMON_SRIRACHA, AVOCADO, EDAMAME, ARDEI_IUTE, SRIRACHA_DRIZZLE, CEAPA_CRISPY, SEMINTE_DE_SUSAN, LIME)));
            Produs TRUFFLE_UMAMI = new Produs("Truffle umami", 54.99, CategorieProdus.SALATA, new ArrayList<> (List.of(BABY_SPANAC, ULEI_EVO, MORCOVI_CU_SUSAN_SI_SOIA, FULGI_DE_GRANA_PADANO, CIUPERCI, CEAPA_ROSIE_MURATA, PUI_SLOW_COOKED, TRUFFLE_MAYO)));
            Produs VELVET_GARDEN = new Produs("Velvet garden", 54.99, CategorieProdus.SALATA, new ArrayList<> (List.of(SALATA_ICEBERG, BALSAMIC_VINAIGRETTE, MORCOVI_CU_SUSAN_SI_SOIA, SFECLA_ROSIE_MURATA, MASLINE, CEAPA_ROSIE_MURATA, BRANZA_TELEMEA, MINT_AND_BASIL)));
            Produs THE_CAESAR = new Produs("The caesar", 59.99, CategorieProdus.SALATA, new ArrayList<> (List.of(SALATA_ICEBERG, BALSAMIC_VINAIGRETTE, ROSII_CHERRY, FULGI_DE_GRANA_PADANO, PUI_SLOW_COOKED, BACON, CRUTOANE, CREAMY_CAESAR, LIME)));
            Produs CHICKEN_VIETNAMITA = new Produs("Chicken vietnamita", 64.99, CategorieProdus.SALATA, new ArrayList<> (List.of(BABY_SPANAC, ULEI_EVO_SI_LIME, COCONUT_BASMATTI, CARTOFI_DULCI_CU_ROZMARIN, BROCCOLI_CU_CHILLI_SI_LIME, VARZA_ROSIE, DOVLECEI, PUI_VIETNAMEZ, SOIA_FARA_GLUTEN)));
            Produs EXOTIC_SALMON = new Produs("Exotic salmon", 64.99, CategorieProdus.SALATA, new ArrayList<> (List.of(BABY_SPANAC, ULEI_EVO_SI_LIME, COCONUT_BASMATTI, CARTOFI_DULCI_CU_ROZMARIN, BROCCOLI_CU_CHILLI_SI_LIME, AVOCADO, SOMON_LA_GRATAR, WASABI_MAYO)));
            Produs HUMMUS_SI_CRUTOANE = new Produs("Hummus si crutoane", 16.9, CategorieProdus.GARNITURA, new ArrayList<> (List.of(HUMUS_PICANT, CRUTOANE)));
            Produs OUA_SI_SPANAC = new Produs("Oua si spanac", 18.9, CategorieProdus.GARNITURA, new ArrayList<> (List.of(OU_FIERT, BABY_SPANAC)));
            Produs MEDITERANEANA = new Produs("Salata mediteraneana", 16.9, CategorieProdus.GARNITURA, new ArrayList<> (List.of(ROSII_CHERRY, CASTRAVETI, BRANZA_TELEMEA, ULEI_EVO)));
            Produs CARTOFI_DULCI_SI_MAIONEZA = new Produs("Cartofi dulci cu maioneza", 22.99, CategorieProdus.GARNITURA, new ArrayList<> (List.of(CARTOFI_DULCI_CU_ROZMARIN, HOUSE_MAYO)));
            Produs WASABI_PEAS_PRODUS = new Produs("Mazare Wasabi", 18.9, CategorieProdus.GARNITURA, new ArrayList<> (List.of(WASABI_PEAS)));
            Produs EDAMAME_PRODUS = new Produs("Edamame", 16.9, CategorieProdus.GARNITURA, new ArrayList<> (List.of(EDAMAME)));
            Produs GOMA_WAKAME = new Produs("Alge Goma Wakame", 22.99, CategorieProdus.GARNITURA, new ArrayList<> (List.of(WAKAME)));
            Produs TIRAMISU_PRODUS = new Produs("Tiramisu",24.99, CategorieProdus.DESERT, new ArrayList<> (List.of(TIRAMISU)));
            Produs BROWNIE_PRODUS = new Produs("Brownie",15.9, CategorieProdus.DESERT, new ArrayList<> (List.of(BROWNIE)));
            Produs MOCHI_PRODUS = new Produs("Mochi",14.99, CategorieProdus.DESERT, new ArrayList<> (List.of(MOCHI)));
            Produs MINI_FRUIT_BOWL = new Produs("Mini bol cu fructe",19.50, CategorieProdus.DESERT, new ArrayList<> (List.of(MANGO, LIME)));

            InstanceHolder.listaProduse.add(VEGETARIAN);
            InstanceHolder.listaProduse.add(CHICKEN);
            InstanceHolder.listaProduse.add(SHRIMP);
            InstanceHolder.listaProduse.add(SPICY_TUNA);
            InstanceHolder.listaProduse.add(SUNNY_SALMON);
            InstanceHolder.listaProduse.add(HOT_AND_SPICY);
            InstanceHolder.listaProduse.add(TRUFFLE_UMAMI);
            InstanceHolder.listaProduse.add(VELVET_GARDEN);
            InstanceHolder.listaProduse.add(THE_CAESAR);
            InstanceHolder.listaProduse.add(CHICKEN_VIETNAMITA);
            InstanceHolder.listaProduse.add(EXOTIC_SALMON);
            InstanceHolder.listaProduse.add(HUMMUS_SI_CRUTOANE);
            InstanceHolder.listaProduse.add(OUA_SI_SPANAC);
            InstanceHolder.listaProduse.add(MEDITERANEANA);
            InstanceHolder.listaProduse.add(CARTOFI_DULCI_SI_MAIONEZA);
            InstanceHolder.listaProduse.add(WASABI_PEAS_PRODUS);
            InstanceHolder.listaProduse.add(EDAMAME_PRODUS);
            InstanceHolder.listaProduse.add(GOMA_WAKAME);
            InstanceHolder.listaProduse.add(TIRAMISU_PRODUS);
            InstanceHolder.listaProduse.add(BROWNIE_PRODUS);
            InstanceHolder.listaProduse.add(MOCHI_PRODUS);
            InstanceHolder.listaProduse.add(MINI_FRUIT_BOWL);

            return lista;
        }
    }

    private ServiciuPrincipal(){}

    public static ServiciuPrincipal getInstance() { return InstanceHolder.instance;}
    
    protected static List<Client> getListaClienti() {return InstanceHolder.listaClienti;}
    protected static List<Locatie> getListaLocatii() {return InstanceHolder.listaLocatii;}
    protected static List<Angajat> getListaAngajati() {return InstanceHolder.listaAngajati;}
    protected static List<Produs> getListaProduse() {return InstanceHolder.listaProduse;}
    protected static List<Ingredient> getListaIngrediente() {return InstanceHolder.listaIngediente;}

    protected static void addAngajatSiLocatie(Angajat ang, int idx){
        InstanceHolder.listaAngajati.add(ang);
        InstanceHolder.listaLocatii.get(idx).addAngajat(ang);
    }

    protected static void addProdus(Produs pr){InstanceHolder.listaProduse.add(pr);}
    protected static Ingredient gasesteIngredientDupaNume(String nume){
        for(Ingredient ingr : getListaIngrediente()){
            if(ingr.getNume().equals(nume))
                return ingr;
        }
        throw new IngredientulNuExista();
    }

    protected static void addIngredient(Ingredient ing){
        for(Ingredient ingLista : getListaIngrediente()){
            if(ingLista.equals(ing))
                throw new IngredientDejaExistaException();
        }
        InstanceHolder.listaIngediente.add(ing);
    }

    public void run(InputStream in){
        try(Scanner sc = new Scanner(in).useDelimiter( "\\n");){
            boolean loopedAlready = false;
            while(true){
                if(!loopedAlready){
                    System.out.println("1. logare client");
                    System.out.println("2. logare admin");
                    System.out.println("out. iesire din aplicatie");
                    System.out.print("> ");
                    loopedAlready = true;
                }
                switch(sc.nextLine().strip()){
                    case "1" -> {
                        boolean foundUser = false;
                        System.out.print("email: ");
                        String email = sc.next().strip();
                        for (Client cl : ServiciuPrincipal.InstanceHolder.listaClienti) {
                            if(cl.getEmail().toLowerCase().equalsIgnoreCase(email)){
                                System.out.println("Email gasit");

                                System.out.print("parola: ");
                                String parola = sc.next().strip();
                                if(cl.getParola().equals(parola)){
                                    System.out.println("Bine ai revenit, " + cl.getPrenume() + "!");
                                    ServiciuClient.getInstance().run(sc, cl);
                                    foundUser = true;
                                }
                            }
                        }
                        if(!foundUser){
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
                            String parola = sc.next().strip();

                            Client cl = new Client(nume, prenume, nrTelefon, email, parola);
                            ServiciuPrincipal.InstanceHolder.listaClienti.add(cl);
                            
                            System.out.println("Bun venit la noi, " + cl.getPrenume() + "!");
                            
                            ServiciuClient.getInstance().run(sc, cl);
                        }
                    }
                    case "2" -> {
                        System.out.print("username: ");
                        String username = sc.next().strip();
                        System.out.print("parola: ");
                        String parola = sc.next().strip();
                        if(username.equals("AdMiNpOkE") && parola.equals("PAROLApoke2005!@!@!@")){
                            System.out.println("Bine ati venit, mr. Admin.");
                            ServiciuAdmin.getInstance().run(sc);
                        }
                    }
                    case "" -> {
                        loopedAlready = false;
                    }
                    case "out" -> {
                        System.out.println("Bye bye!");
                        System.out.flush();
                        return;
                    }
                    default -> {
                        System.out.println("Input necunoscut; incercati din nou.");
                    }
                }
            }
        }
    }
}