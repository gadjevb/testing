package com.clouway.testing.task3;

import java.util.*;

public class Warehouse {
    private int spaceForMerchandise = 200;
    private final ArrayList<Merchandise> stock = new ArrayList<>();

    /**
     *Adds merchandise to stock method -> addMerchandise() adds the given merchandise to the stock list after a check for space in the Warehouse
     *If spaceForMerchandise is greater than 0, the merchandise will be saved and spaceForMerchandise will be decremented,
     *otherwise WarehouseIsFullException will be thrown.
     */

    public void addMerchandise(Merchandise object) throws WarehouseIsFullException {
        if((spaceForMerchandise - object.getQuantity()) >= 0){
            spaceForMerchandise -= object.getQuantity();
            stock.add(object);
        }else{
            throw new WarehouseIsFullException();
        }
    }

    /**
     *Helping method for the tests,
     *getMerchandiseAtPosition() is NOT required for the task!
     */

    public Merchandise getMerchandiseAtPosition(int i) {
        Merchandise temp = stock.get(i);
        return temp;
    }

    /**
     *Sells merchandise -> sellMerchandise() method sells merchandise by the given characteristics and budget of the buyer,
     *if a merchandise that fulfills the characteristics is found a True will be returned and the merchandise will be removed from the warehouse
     *and spaceForMerchandise will be incremented, if there is no such merchandise False will be returned this means that there is no such merchandise that
     *fulfills the buyer requirements. If the Warehouse is empty the method will throw WarehouseIsEmptyException.
     */

    public boolean sellMerchandise(String objectType, String objectModel, int objectPrice, int objectQuantity) throws WarehouseIsEmptyException {
        if(stock.isEmpty()){
            throw new WarehouseIsEmptyException();
        }else {
            for (int i = 0; i < stock.size(); i++) {
                Merchandise temp = stock.get(i);
                if ((objectType.equals(temp.getType())) && (objectModel.equals(temp.getModel())) && (objectPrice >= temp.price) && (objectQuantity <= temp.getQuantity())) {
                    if(objectQuantity < temp.getQuantity()){
                        int diff = temp.getQuantity() - objectQuantity;
                        temp.setQuantity(diff);
                        spaceForMerchandise += objectQuantity;
                        return true;
                    }else if(objectQuantity == temp.getQuantity()){
                        stock.remove(i);
                        spaceForMerchandise += objectQuantity;
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *Sorts the list that contains the Merchandise objects by their price,
     *overriden comparator for the Merchandise class is being used, the method will
     *@return sorted ArrayList of Merchandise objects.
     */

    public ArrayList<Merchandise> listMerchandiseByPrice() {
        Collections.sort(stock,new PriceComparator());
        return stock;
    }
}
