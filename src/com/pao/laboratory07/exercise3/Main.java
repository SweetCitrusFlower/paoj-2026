package com.pao.laboratory07.exercise3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int n = Integer.parseInt(sc.nextLine().trim());
            List<Comanda> comenzi = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                String line = sc.nextLine().trim();
                String[] tokens = line.split(" ");

                String nume = tokens[1];
                switch (tokens[0]) {
                    case "STANDARD" -> {
                        double pret = Double.parseDouble(tokens[2]);
                        String client = tokens[3];
                        
                        comenzi.add(new ComandaStandard(nume, pret, client));
                    }
                    case "DISCOUNTED" -> {
                        double pret = Double.parseDouble(tokens[2]);
                        int discount = Integer.parseInt(tokens[3]);
                        String client = tokens[4];
                        
                        comenzi.add(new ComandaRedusa(nume, pret, discount, client));
                    }
                    case "GIFT" -> {
                        String client = tokens[2];
                        
                        comenzi.add(new ComandaGratuita(nume, client));
                    }
                }
            }

            for (Comanda c : comenzi) {
                System.out.println(c.descriere());
            }

            boolean primesteComenzi = true;
            while(primesteComenzi){

                String command = sc.nextLine().trim();
                String[] tokens = command.split(" ");

                System.out.println();
                switch(tokens[0]){
                    case "QUIT" -> {primesteComenzi = false;}
                    case "STATS" -> {
                        System.out.println("--- STATS ---");
                        Map<TipComanda, List<Comanda>> comenziGroupedBy = comenzi.stream().collect(Collectors.groupingBy(Comanda::getTipComanda));
                        for (Map.Entry<TipComanda, List<Comanda>> en : comenziGroupedBy.entrySet()) {
                            System.out.printf("%s: medie = %.2f lei\n", en.getKey().name(), en.getValue().stream().collect(Collectors.averagingDouble(c -> c.pretFinal())));
                        }
                    }
                    case "FILTER" -> {
                        System.out.printf("--- FILTER (>= %.2f) ---\n", Double.valueOf(tokens[1]));
                        List<Comanda> FilteredList = comenzi.stream().filter(c -> c.pretFinal() >= Double.parseDouble(tokens[1])).collect(Collectors.toList());
                        for (Comanda c : FilteredList) {
                            System.out.println(c.descriere());
                        }
                    }
                    case "SORT" -> {
                        System.out.println("--- SORT (by client, then by pret) ---");

                        comenzi.sort(Comparator.comparing(Comanda::getClient).thenComparing(Comanda::pretFinal));
                        for (Comanda c : comenzi) {
                            System.out.println(c.descriere());
                        }
                    }
                    case "SPECIAL" -> {
                        System.out.println("--- SPECIAL (discount > 15%) ---");
                        List<Comanda> specialList = comenzi.stream().filter(c -> c instanceof ComandaRedusa).filter(c -> ((ComandaRedusa)c).getDiscount() > 15).collect(Collectors.toList());
                        for (Comanda c : specialList) {
                            System.out.println(c.descriere());
                        }
                    }
                    default ->{
                        System.out.println("Command not found");
                    }
                }
            }
        }
        }
}