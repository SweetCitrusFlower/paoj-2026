package com.pao.project;

import com.pao.project.service.ServiciuPrincipal;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        String[][] teste = {
            {"1", "alexhancu49@gmail.com", "parola123", "2", "0 2", "2", "0", "out", "out"},
            {"1", "alexhancu49@gmail.com", "parola123", "3", "4", "7", "out", "out"},
            {"1", "alexhancu49@gmail.com", "parola123", "5", "Blvd. 1848", "63", "37", "540421", "4", "out", "out"},
            {"1", "alexhancu49@gmail.com", "parola123", "1", "2", "15 3", "y", "20 2", "n", "1", "1", "7", "out", "out"},

            {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "out", "out"},
            {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "1", "Bere", "DESERT", "out", "out"},
            {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "2", "Salsa verde", "345", "DESERT", "3", "Ardei iute", "avoc", "Avocado", "Ulei evo", "out", "out"},
            {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "3", "Slay", "Queen", "0769420676", "4600", "2", "Y", "out", "out"},
            {"2", "AdMiNpOkE", "PAROLApoke2005!@!@!@", "4", "5", "6", "out", "out"}
        };

        for(String[] test : teste){
            StringWriter sw = new StringWriter();
            PrintWriter out = new PrintWriter(sw);
            for (String s : test) {out.println(s);}
            InputStream stream = new ByteArrayInputStream(sw.toString().getBytes());
            ServiciuPrincipal.getInstance().run(stream);
        }

        // ServiciuPrincipal.getInstance().run(System.in);
    }
}