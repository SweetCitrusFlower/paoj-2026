package com.pao.laboratory06.exercise3;

import java.util.ArrayList;
import java.util.List;

public class PersoanaJuridica extends Persoana implements PlataOnlineSMS{
    private double sold = 100000.0;
    private List<String> smsTrimise;

    public PersoanaJuridica(String nume, String prenume, String telefon) {
        super(nume, prenume, telefon);
        this.smsTrimise = new ArrayList<>();
    }

    public List<String> getSmsTrimise() {
        return List.copyOf(smsTrimise);
    }

    @Override
    public boolean trimiteSMS(String mesaj){
        if(this.getTelefon() == null || this.getTelefon().isEmpty())
            return false;
        if(mesaj == null || mesaj.isEmpty())
            return false;
        smsTrimise.add(mesaj);
        return true;
    }

    @Override
    public void autentificare(String user, String parola) {
        if(user == null || parola == null || user.isEmpty() || parola.isEmpty())
            throw new IllegalArgumentException("Incercare de autentificare cu user sau parola nule");
    }

    @Override
    public double consultareSold() {
        return this.sold;
    }

    @Override
    public boolean efectuarePlata(double suma) {
        if(suma > this.consultareSold() || suma < 0)
            return false;
        this.sold -= suma;
        return true;
    }    
}
