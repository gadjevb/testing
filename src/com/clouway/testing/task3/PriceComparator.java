package com.clouway.testing.task3;

import java.util.Comparator;

public class PriceComparator implements Comparator<Merchandise> {

    @Override
    public int compare(Merchandise first, Merchandise second){
        if(first.price > second.price){
            return 1;
        }else if(first.price < second.price){
            return -1;
        }
        return 0;
    }
}
