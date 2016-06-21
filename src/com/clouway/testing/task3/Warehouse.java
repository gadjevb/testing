package com.clouway.testing.task3;

import java.util.*;

public class Warehouse {
    private int spaceForMerchandise = 2;
    ArrayList<Merchandise> stock = new ArrayList<>();

    public void addMerchandise(Merchandise object) throws WarehouseIsFullException {
        if(spaceForMerchandise > 0){
            spaceForMerchandise--;
            stock.add(object);
        }else{
            throw new WarehouseIsFullException();
        }
    }

    public boolean sellMerchandise(String objectType, String objectModel, int objectPrice){

        return false;
    }

    public Merchandise getMerchandiseAtPosition(int i) {
        Merchandise temp = stock.get(i);
        return temp;
    }
}
