package com.pao.laboratory06.exercise3;

public class ComparatorInginerSalariu implements Comparator<Inginer>{
    public int compare(Inginer i1, Inginer i2){
        return Double.compare(i1.getSalariu(), i2.getSalariu());
    }
}
