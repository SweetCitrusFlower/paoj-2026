package com.pao.laboratory05.audit;

import java.util.Scanner;

/**
 * Exercise 4 (Bonus) — Audit Log
 *
 * Cerințele complete se află în:
 *   src/com/pao/laboratory05/Readme.md  →  secțiunea "Exercise 4 (Bonus) — Audit"
 *
 * Extinde soluția de la Exercise 3 cu un sistem de audit bazat pe record.
 * Creează fișierele de la zero în acest pachet, apoi rulează Main.java
 * pentru a verifica output-ul așteptat din Readme.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AngajatService angajatService = AngajatService.getInstance();

        while (true) {
            System.out.println("\n===== Gestionare Angajați (cu Audit) =====");
            System.out.println("1. Adaugă angajat");
            System.out.println("2. Listare după salariu");
            System.out.println("3. Caută după departament");
            System.out.println("4. Audit Log");
            System.out.println("0. Ieșire");
            System.out.print("Opțiune: ");

            String raspuns = scanner.nextLine();
            if(raspuns.compareTo("1") == 0){
                System.out.print("Nume: ");
                String numeAngajat = scanner.nextLine();
                
                System.out.print("Departament (nume): ");
                String numeDepartament = scanner.nextLine();
                
                System.out.print("Departament (locatie): ");
                String locatieDepartament = scanner.nextLine();
                
                System.out.print("Salariu: ");
                String salariuAngajatString = scanner.nextLine();
                double salariuAngajat = Double.parseDouble(salariuAngajatString);

                angajatService.addAngajat(new Angajat(numeAngajat, new Departament(numeDepartament, locatieDepartament), salariuAngajat));

            }
            else if(raspuns.compareTo("2") == 0){
                System.out.println("--- Angajați după salariu (descrescător) ---");
                angajatService.listBySalary();
            }
            else if(raspuns.compareTo("3") == 0){
                System.out.print("Departament (nume): ");
                String numeDepartament = scanner.nextLine();

                System.out.println("--- Angajati din " + numeDepartament + " ---");
                angajatService.findByDepartament(numeDepartament);
            }
            else if(raspuns.compareTo("4") == 0){
                System.out.println("--- Audit Log ---");
                angajatService.printAuditLog();
            }
            else if(raspuns.compareTo("0") == 0){
                System.out.println("La revedere!");
                break;
            }
        }
    }
}
