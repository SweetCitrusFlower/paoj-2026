package com.pao.project.comparators;

import com.pao.project.enums.Produs;
import java.util.Comparator;

public class ComparatorProduseNume implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return p1.getDenumire().compareTo(p2.getDenumire());
    }
}
