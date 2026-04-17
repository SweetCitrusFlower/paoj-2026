package com.pao.project.comparators;

import com.pao.project.enums.Produs;
import java.util.Comparator;

public class ComparatorProdusePret implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return Double.compare(p1.getPret(), p2.getPret());
    }
}