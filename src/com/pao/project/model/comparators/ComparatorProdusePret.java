package com.pao.project.model.comparators;

import java.util.Comparator;

import com.pao.project.model.Produs;

public class ComparatorProdusePret implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return Double.compare(p1.getPret(), p2.getPret());
    }
}