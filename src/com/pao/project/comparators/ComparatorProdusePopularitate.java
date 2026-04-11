package com.pao.project.comparators;

import com.pao.project.Produs;
import java.util.Comparator;

public class ComparatorProdusePopularitate implements Comparator<Produs>{
    @Override
    public int compare(Produs p1, Produs p2){
        return Integer.compare(p1.getCntComandat(), p2.getCntComandat());
    }
}
