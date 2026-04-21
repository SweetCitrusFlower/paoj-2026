package com.pao.project.model.comparators;

import java.util.Comparator;

import com.pao.project.model.Produs;

public class ComparatorProduseNume implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return p1.getDenumire().compareTo(p2.getDenumire());
    }
}
