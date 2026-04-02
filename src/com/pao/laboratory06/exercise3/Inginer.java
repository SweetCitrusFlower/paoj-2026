package com.pao.laboratory06.exercise3;

public class Inginer extends Angajat implements PlataOnline, Comparable<Inginer>{
    @Override
    public int compareTo(Inginer other) {
        return this.getNume().compareTo(other.getNume());
    }
}
