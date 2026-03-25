package com.pao.laboratory05.audit;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AngajatService {

    private static class InstanceHolder {
        public static AngajatService instance = new AngajatService();
    }

    private AngajatService(){}

    public static AngajatService getInstance(){
        return InstanceHolder.instance;
    }
    
    private Angajat[] angajati = new Angajat[0];
    private AuditEntry[] auditLog = new AuditEntry[0];

    public void addAngajat(Angajat angajat){
        System.arraycopy(angajati, 0, angajati = new Angajat[angajati.length + 1], 0, angajati.length - 1);
        angajati[angajati.length - 1] = angajat;
        System.out.println("Angajat " + angajat.getNume() + " adaugata!");
        logAction("ADD", angajat.getNume());
    }

    public void printAll(){
        for (Angajat angajat : angajati) {
            System.out.println(angajat);
        }
    }

    public void listBySalary(){
        Angajat[] copy = this.angajati.clone();
        Arrays.sort(copy);
        for (Angajat angajat : copy) {
            System.out.println(angajat);
        }
    }

    public void findByDepartament(String numeDept){
        boolean afisat = false;
        for(Angajat angajat : angajati){
            if(angajat.getDepartament().nume().equalsIgnoreCase(numeDept)){
                System.out.println(angajat);
                afisat = true;
            }
        }

        if(!afisat){
            System.out.println("Niciun angajat în departamentul: " + numeDept + '"');
        }
        logAction("FIND_BY_DEPT", numeDept);
    }

    private void logAction(String action, String target){
        System.arraycopy(auditLog, 0, auditLog = new AuditEntry[auditLog.length + 1], 0, auditLog.length - 1);
        String timestamp = LocalDateTime.now().toString();
        auditLog[auditLog.length - 1] = new AuditEntry(action, target, timestamp);
    }

    public void printAuditLog(){
        for (AuditEntry elem : auditLog) {
            System.out.println(elem);
        }
    }
}
