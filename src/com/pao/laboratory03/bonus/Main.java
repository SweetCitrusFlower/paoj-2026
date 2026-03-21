package com.pao.laboratory03.bonus;

import java.util.List;
import java.util.Map;

/**
 * Exercițiul 5 (Bonus) — Sistem de gestiune task-uri cu audit log
 *
 * Construiește un sistem complet FĂRĂ schelet de cod.
 * Primești doar cerințele — tu decizi structura claselor.
 *
 * ═══════════════════════════════════════════════════════
 *  CERINȚE FUNCȚIONALE
 * ═══════════════════════════════════════════════════════
 *
 * Sistemul gestionează task-uri. Fiecare task are:
 *   - String id (unic, format "T001", "T002", ...)
 *   - String title
 *   - Status status (enum: TO_DO, IN_PROGRESS, DONE, CANCELLED)
 *   - Priority priority (enum: LOW, MEDIUM, HIGH, CRITICAL)
 *   - String assignee (persoana responsabilă, poate fi null)
 *
 * ═══════════════════════════════════════════════════════
 *  ENUM-URI (creează 2 enum-uri)
 * ═══════════════════════════════════════════════════════
 *
 * 1. Status — cu metoda abstractă boolean canTransitionTo(Status next):
 *    - TO_DO → poate trece la IN_PROGRESS sau CANCELLED
 *    - IN_PROGRESS → poate trece la DONE sau CANCELLED
 *    - DONE → nu poate trece nicăieri
 *    - CANCELLED → nu poate trece nicăieri
 *
 * 2. Priority — cu câmpuri (int level, double multiplier):
 *    - LOW(1, 1.0), MEDIUM(2, 1.5), HIGH(3, 2.0), CRITICAL(4, 3.0)
 *    - Metodă: double calculateScore(int baseDays)
 *      → returnează baseDays * multiplier (scor de urgență)
 *
 * ═══════════════════════════════════════════════════════
 *  EXCEPȚII (creează 3 excepții custom)
 * ═══════════════════════════════════════════════════════
 *
 * 1. DuplicateTaskException extends RuntimeException
 * 2. TaskNotFoundException extends RuntimeException
 * 3. InvalidTransitionException extends RuntimeException
 *    - Câmp extra: Status fromStatus, Status toStatus
 *    - getMessage() → "Nu se poate trece din IN_PROGRESS în TO_DO"
 *
 * ═══════════════════════════════════════════════════════
 *  SERVICIU — TaskService (Singleton)
 * ═══════════════════════════════════════════════════════
 *
 * Structuri de date interne:
 *   - Map<String, Task> tasksById — toate task-urile, indexate după id
 *   - Map<Priority, List<Task>> tasksByPriority — grupate pe prioritate
 *   - List<String> auditLog — jurnal cu TOATE operațiile efectuate
 *
 * Metode:
 *   a) Task addTask(String title, Priority priority)
 *      → generează id automat ("T001", "T002", ...)
 *      → adaugă în ambele map-uri
 *      → logează: "[ADD] T001: 'Fix bug' (HIGH)"
 *
 *   b) void assignTask(String taskId, String assignee)
 *      → aruncă TaskNotFoundException dacă id-ul nu există
 *      → logează: "[ASSIGN] T001 → Ana"
 *
 *   c) void changeStatus(String taskId, Status newStatus)
 *      → aruncă TaskNotFoundException dacă id-ul nu există
 *      → aruncă InvalidTransitionException dacă tranziția nu e permisă
 *        (folosește Status.canTransitionTo())
 *      → logează: "[STATUS] T001: TO_DO → IN_PROGRESS"
 *
 *   d) List<Task> getTasksByPriority(Priority priority)
 *      → returnează lista din map (sau listă goală)
 *
 *   e) Map<Status, Long> getStatusSummary()
 *      → returnează câte task-uri sunt pe fiecare status
 *      → exemplu: {TO_DO=3, IN_PROGRESS=2, DONE=5, CANCELLED=1}
 *
 *   f) List<Task> getUnassignedTasks()
 *      → task-uri cu assignee == null
 *
 *   g) void printAuditLog()
 *      → afișează toate intrările din jurnal
 *
 *   h) double getTotalUrgencyScore(int baseDays)
 *      → suma scorurilor de urgență ale task-urilor care NU sunt DONE/CANCELLED
 *      → folosește Priority.calculateScore(baseDays)
 *
 * ═══════════════════════════════════════════════════════
 *  MAIN — demonstrează TOATE funcționalitățile
 * ═══════════════════════════════════════════════════════
 *
 * În metoda main:
 * 1. Adaugă minim 5 task-uri cu priorități diferite
 * 2. Asignează 3 task-uri
 * 3. Schimbă status-ul la câteva task-uri (inclusiv o tranziție invalidă în try-catch)
 * 4. Afișează task-uri pe prioritate HIGH
 * 5. Afișează sumarul pe status
 * 6. Afișează task-uri neasignate
 * 7. Calculează scorul de urgență total
 * 8. Afișează audit log-ul complet
 * 9. Încearcă să adaugi un task cu id duplicat → DuplicateTaskException
 * 10. Încearcă să cauți un task inexistent → TaskNotFoundException
 *
 * Output așteptat (orientativ):
 *
 * === Adăugare task-uri ===
 * Adăugat: Task{id='T001', title='Fix login bug', priority=CRITICAL, status=TO_DO}
 * Adăugat: Task{id='T002', title='Add dark mode', priority=LOW, status=TO_DO}
 * Adăugat: Task{id='T003', title='Update docs', priority=MEDIUM, status=TO_DO}
 * Adăugat: Task{id='T004', title='Fix memory leak', priority=HIGH, status=TO_DO}
 * Adăugat: Task{id='T005', title='Refactor DB layer', priority=HIGH, status=TO_DO}
 *
 * === Asignare ===
 * T001 → Ana
 * T003 → Mihai
 * T004 → Elena
 *
 * === Schimbări status ===
 * T001: TO_DO → IN_PROGRESS ✓
 * T001: IN_PROGRESS → DONE ✓
 * T003: TO_DO → IN_PROGRESS ✓
 * T001: DONE → TO_DO → InvalidTransitionException: Nu se poate trece din DONE în TO_DO
 *
 * === Task-uri HIGH ===
 * Task{id='T004', title='Fix memory leak', priority=HIGH, status=TO_DO, assignee=Elena}
 * Task{id='T005', title='Refactor DB layer', priority=HIGH, status=TO_DO, assignee=null}
 *
 * === Sumar status ===
 * TO_DO: 2
 * IN_PROGRESS: 1
 * DONE: 1
 * CANCELLED: 0
 *
 * === Task-uri neasignate ===
 * T002: Add dark mode
 * T005: Refactor DB layer
 *
 * === Scor urgență (baseDays=5) ===
 * Total: 40.0
 *
 * === Audit Log ===
 * [ADD] T001: 'Fix login bug' (CRITICAL)
 * [ADD] T002: 'Add dark mode' (LOW)
 * [ADD] T003: 'Update docs' (MEDIUM)
 * [ADD] T004: 'Fix memory leak' (HIGH)
 * [ADD] T005: 'Refactor DB layer' (HIGH)
 * [ASSIGN] T001 → Ana
 * [ASSIGN] T003 → Mihai
 * [ASSIGN] T004 → Elena
 * [STATUS] T001: TO_DO → IN_PROGRESS
 * [STATUS] T001: IN_PROGRESS → DONE
 * [STATUS] T003: TO_DO → IN_PROGRESS
 *
 * === Excepții ===
 * TaskNotFoundException: Task-ul 'T999' nu a fost găsit
 */
class TaskService 
{
    private static TaskService single_instance = null;
    private static int autoId = 0;
    private TaskService(){

    }

    Map<String, Task> tasksById;
    Map<Priority, List<Task>> tasksByPriority;
    List<String> auditLog;

    public static synchronized TaskService getInstance()
    {
        if (single_instance == null)
            single_instance = new TaskService();
        return single_instance;
    }
}
public class Main {
    static int baseDays = 5;
    public static void main(String[] args) {
        TaskService TS = TaskService.getInstance();

        // TO_DO: implementează toți cei 10 pași de mai sus
        // Creează TOATE clasele necesare în acest pachet (bonus/)
        // Nu ai subpachete impuse — organizează cum consideri
    }
}


