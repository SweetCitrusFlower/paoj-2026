package com.pao.laboratory06.exercise3;

public class Inginer extends Angajat implements PlataOnline, Comparable<Inginer>{
    private double sold = 5000.0;
    
    public Inginer(String nume, String prenume, String telefon, double salariu) {
        super(nume, prenume, telefon, salariu);
    }

    @Override
    public int compareTo(Inginer other) {
        return this.getNume().compareTo(other.getNume());
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
