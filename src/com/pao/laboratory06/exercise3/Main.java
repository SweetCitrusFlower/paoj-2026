package com.pao.laboratory06.exercise3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) 
    {
        Inginer[] ingineri = new Inginer[]{
                new Inginer("Popescu", "Ion", "0712345678", 5000),
                new Inginer("Ionescu", "Ana", "0722222222", 7000),
                new Inginer("Georgescu", "Mihai", null, 6000)
        };

        System.out.println("=== Sortare naturala (dupa nume) ===");
        Arrays.sort(ingineri);
        for (Inginer i : ingineri) {
            i.afisare();
        }

        System.out.println("\n=== Sortare dupa salariu (descrescator) ===");
        Arrays.sort(ingineri, new ComparatorInginerSalariu());
        for (Inginer i : ingineri) {
            i.afisare();
        }

        
        System.out.println("\n=== interfata PlataOnline ===");
        PlataOnline ing0 = ingineri[0];
        try {
            ing0.autentificare("user1", "pass1");
            System.out.println("Sold: " + ing0.consultareSold());
            System.out.println("Plata efectuata: " + ing0.efectuarePlata(100));
        } catch (Exception e) {
            System.out.println("Eroare PlataOnline: " + e.getMessage());
        }

        
        System.out.println("\n=== PersoanaJuridica cu SMS ===");

        PersoanaJuridica PersJurid1 = new PersoanaJuridica("Firma", "SRL", "0733333333");
        System.out.println("Trimite SMS valid: " + PersJurid1.trimiteSMS("Plata efectuata"));
        System.out.println("Trimite SMS gol: " + PersJurid1.trimiteSMS(""));


        System.out.println("\n=== PersoanaJuridica fara telefon ===");

        PersoanaJuridica firmaFaraTel = new PersoanaJuridica("NoTel", "SRL", "");
        System.out.println("Trimite SMS fara telefon: " + firmaFaraTel.trimiteSMS("Test"));

        System.out.println("\n=== SMS pe Inginer ===");

        try {
            ((PlataOnlineSMS)ing0).trimiteSMS("Inginer cu puteri supranaturale");
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n=== autentificare invalida ===");

        try {
            ing0.autentificare(null, "pass");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Constante financiare ===");

        for (ConstanteFinanciare c : ConstanteFinanciare.values()) {
            System.out.printf("%s: %s\n", c.name(), c.getValoare());
        }

        
        System.out.println("\n=== SMS trimise PersJurid1 ===");

        for (String msg : PersJurid1.getSmsTrimise()) {
            System.out.println(msg);
        }
    }
}