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

    public Merchandise getMerchandiseAtPosition(int i) {
        Merchandise temp = stock.get(i);
        return temp;
    }

    public boolean sellMerchandise(String objectType, String objectModel, int objectPrice) throws WarehouseIsEmptyException {
        if(stock.isEmpty()){
            throw new WarehouseIsEmptyException();
        }else {
            for (int i = 0; i < stock.size(); i++) {
                Merchandise temp = stock.get(i);
                if (objectType.equals(temp.getType()) && objectModel.equals(temp.getModel()) && objectPrice >= temp.price) {
                    stock.remove(i);
                    spaceForMerchandise++;
                    return true;
                }
            }
        }
        return false;
    }


}
