package com.clouway.testing.task3;

import java.util.*;

public class Warehouse {
    private int spaceForMerchandise = 2;
    ArrayList<Merchandise> stock = new ArrayList<>();

    /**
     *addMerchandise() methods adds the given merchandise to the stock list after a check for space in the Warehouse
     *If spaceForMerchandise is greater than 0, the merchandise will be saved and spaceForMerchandise will be decremented,
     *otherwise WarehouseIsFullException will be thrown.
     */

    public void addMerchandise(Merchandise object) throws WarehouseIsFullException {
        if(spaceForMerchandise > 0){
            spaceForMerchandise--;
            stock.add(object);
        }else{
            throw new WarehouseIsFullException();
        }
    }

    /**
     *getMerchandiseAtPosition() is NOT required for the task,
     *it's a helping method for the tests
     */

    public Merchandise getMerchandiseAtPosition(int i) {
        Merchandise temp = stock.get(i);
        return temp;
    }

    /**
     *sellMerchandise() method sells merchandise by the given characteristics and budget of the buyer,
     *if a merchandise that fulfills the characteristics is found a True will be returned and the merchandise will be removed from the warehouse
     *and spaceForMerchandise will be incremented, if there is no such merchandise False will be returned this means that there is no such merchandise that
     *fulfills the buyer requirements. If the Warehouse is empty the method will throw WarehouseIsEmptyException.
     */

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

    /*
     sortByPrice() method, I defined a custom comparator because it makes life easier
     */

    public ArrayList<Merchandise> listMerchandiseByPrice() {
        Collections.sort(stock,new PriceComparator());
        return stock;
    }

}
