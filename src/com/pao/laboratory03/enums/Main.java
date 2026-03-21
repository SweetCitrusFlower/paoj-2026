package com.pao.laboratory03.enums;


/**
 * Exercițiul 2 — Enum-uri

 * PASUL 2 — În acest Main.java:
 *   a) Parcurge toate valorile cu Priority.values() și afișează:
 *      "emoji name (level=X, color=Y)"
 *   b) Folosește switch pe un Priority și afișează un mesaj specific.
 *   c) Convertește un String în Priority cu Priority.valueOf("HIGH") — afișează rezultatul.
 *   d) Demonstrează compararea: folosește == între două enum-uri (NU .equals()).
 *   e) Afișează name() și ordinal() pentru fiecare constantă.
 *
 * Output așteptat:
 *
 * === Toate prioritățile ===
 * 🟢 LOW (level=1, color=green)
 * 🟡 MEDIUM (level=2, color=yellow)
 * 🟠 HIGH (level=3, color=orange)
 * 🔴 CRITICAL (level=4, color=red)
 *
 * === Switch pe prioritate ===
 * ⚠️ Atenție! Prioritate ridicată!
 *
 * === valueOf ===
 * Priority.valueOf("HIGH") = HIGH
 *
 * === Comparare enum ===
 * HIGH == HIGH? true
 * HIGH == LOW? false
 *
 * === name() și ordinal() ===
 * LOW: name=LOW, ordinal=0
 * MEDIUM: name=MEDIUM, ordinal=1
 * HIGH: name=HIGH, ordinal=2
 * CRITICAL: name=CRITICAL, ordinal=3
 */
public class Main {
    public static void main(String[] args) {
        for (Priority pr : Priority.values()) {
            System.out.println(pr.getEmoji() + " " + pr.name() + " (level=" + pr.getLevel() + ", color=" + pr.getColor() + ")");
        }
        Priority pr = Priority.LOW;
        switch (pr) {
            case LOW -> System.out.println("Prioritate scazuta (e chill vere)");
            case MEDIUM -> System.out.println("Prioritate medie.");
            case HIGH -> System.out.println("Prioritate ridicata!");
            case CRITICAL -> System.out.println("Atenție! Prioritate critică!");
        }

        Priority prMedium = Priority.valueOf("MEDIUM");
        System.out.println("Priority.valueOf(\"MEDIUM\") = " + prMedium);

        Priority fromString = Priority.valueOf("MEDIUM");
        System.out.println("MEDIUM == MEDIUM? " + (fromString == Priority.MEDIUM));
        System.out.println("MEDIUM == HIGH? " + (fromString == Priority.HIGH));

        for (Priority s : Priority.values()) {
            System.out.println("  " + s.name() + " (ordinal=" + s.ordinal() + ")");
        }
    }

}

