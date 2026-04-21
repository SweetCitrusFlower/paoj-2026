package com.pao.project.model.comparators;

import java.util.Comparator;

import com.pao.project.model.Produs;

public class ComparatorProdusePopularitate implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return -Integer.compare(p1.popularitate, p2.popularitate);
    }
}
