package com.pao.project;

import com.pao.project.model.Client;
import com.pao.project.repository.ClientRepository;
import com.pao.project.service.AuditService;
import com.pao.project.service.ServiciuPrincipal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        ServiciuPrincipal.getInstance();
        AuditService audit = AuditService.getInstance();

        ClientRepository clRepo = new ClientRepository();

        // ---- Actiunea 1: Adauga client----
        Client cl = new Client("Nou","Client","0712345678","email_care_acum_exista@gmail.com", "parolaClientNou333");
        clRepo.save(cl);
        audit.log("add_client");
        System.out.println("1. client adaugat: " + cl);

        // String[][] teste = {
        //     {"1", "email_care_nu_exista@gmail.com", "Nou","Client","0712345678","email_care_acum_exista@gmail.com", "parolaClientNou333", "out", "out"},
            
        //     {"1", "alexhancu49@gmail.com", "parola123", "1", "2", "15 3", "y", "20 2", "n", "1", "1", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "2", "0 2", "2", "1", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "3", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "4", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "5", "Blvd. 1848", "63", "37", "540421", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "6", "nu_e_numar", "1", "out", "out"},
        //     {"1", "alexhancu49@gmail.com", "parola123", "7", "out", "out"},

        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "1", "prajitura", "DESERT", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "2", "Salsa verde", "345", "GARNITURA", "3", "Ardei iute", "avoc", "Avocado", "Ulei evo", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "3", "Slay", "Queen", "0769420676", "4600", "2", "Y", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "4", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "5", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "6", "out", "out"},
        //     {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "7", "out", "out"},
        // };

        // // for(String[] test : teste){
        // //     StringWriter sw = new StringWriter();
        // //     PrintWriter out = new PrintWriter(sw);
        // //     for (String s : test) {out.println(s);}
        // //     InputStream stream = new ByteArrayInputStream(sw.toString().getBytes());
        // //     ServiciuPrincipal.getInstance().run(stream);
        // // }

        // try(Scanner sc = new Scanner(System.in)){   
        //     while (true) {
        //         System.out.println("");
        //         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //         System.out.println("");
        //         System.out.println("Testare:");
        //         System.out.println("1. ServiciuClient - creare cont nou client");
        //         System.out.println("2. ServiciuClient - plasare comanda");
        //         System.out.println("3. ServiciuClient - afisare anumite produse disponibile, sortate dupa popularitate");
        //         System.out.println("4. ServiciuClient - afisare card fidelitate");
        //         System.out.println("5. ServiciuClient - afisare adrese livrare");
        //         System.out.println("6. ServiciuClient - adaugare adresa livrare");
        //         System.out.println("7. ServiciuClient - stergere adresa livrare");
        //         System.out.println("8. ServiciuClient - afisare istoric comenzi");

        //         System.out.println("9. ServiciuAdmin - adaugare ingredient nou");
        //         System.out.println("10. ServiciuAdmin - adaugare produs nou");
        //         System.out.println("11. ServiciuAdmin - adaugare angajat nou");
        //         System.out.println("12. ServiciuAdmin - afisare toate ingredientele");
        //         System.out.println("13. ServiciuAdmin - afisare toate produsele");
        //         System.out.println("14. ServiciuAdmin - afisare toti angajatii");
        //         System.out.println("15. ServiciuAdmin - afisare toti clientii");
        //         System.out.println("out. iesire din testare "); 
        //         String input = sc.next().strip();
        //         try {
        //             StringWriter sw = new StringWriter();
        //             PrintWriter out = new PrintWriter(sw);
        //             int number = Integer.parseInt(input);
        //             if(number <= 0 || number >= 16)
        //                 throw new NumberFormatException();
        //             for (String s : teste[number - 1]) {out.println(s);}
        //             InputStream stream = new ByteArrayInputStream(sw.toString().getBytes());
        //             ServiciuPrincipal.getInstance().run(stream);
        //         } catch (NumberFormatException e) {
        //             switch(input){
        //                 case "out" -> {return;}
        //                 default -> {System.out.println("Input necunoscut; incercati din nou.");}
        //             }
        //         }
        //     }
        // }
    }
}