package com.clouway.testing.test.task3;

import com.clouway.testing.task3.*;
import static org.junit.Assert.*;
import org.junit.*;

public class WarehouseTDD {

    /**
    The first two test check is the Warehouse and Merchandise objects
     are created.
     */

    @Test
    public void createWarehouseObject(){
        Warehouse warehouse = new Warehouse();
        assertNotNull(warehouse);
    }

    @Test
    public void createMerchandiseObject(){
        Merchandise temp = new Merchandise("Televisor","Neo",350);
        assertNotNull(temp);
    }

    /**
    The next two test check the addMerchandise() method for the Warehouse class
     and the WarehouseIsFullException
     */

    @Test
    public void addMerchandiseToWarehouse() {
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        Merchandise temp = new Merchandise("Fridge","Bosch",800);
        try {
            warehouse.addMerchandise(merch1);
        } catch (WarehouseIsFullException e) {
            e.getMessage();
        }
        Merchandise tempMerch1 = warehouse.getMerchandiseAtPosition(0);
        assertEquals(temp.getType(),tempMerch1.getType());
        assertEquals(temp.getModel(),tempMerch1.getModel());
        assertEquals(temp.getPrice(),tempMerch1.getPrice());
    }

    @Test(expected = WarehouseIsFullException.class)
    public void addMerchandiseToFullWarehouse() throws WarehouseIsFullException {
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        warehouse.addMerchandise(merch1);
        Merchandise merch2 = new Merchandise("Fridge","Bosch",800);
        warehouse.addMerchandise(merch2);
        Merchandise merch3 = new Merchandise("Fridge","Bosch",800);
        warehouse.addMerchandise(merch3);
    }

    /**
     The next three test check the sellMerchandise() method when the searched product is found,
     when the searched product is NOT found and the WarehouseIsEmptyException
     */

    @Test
    public void sellMerchandise(){
        boolean flag = false;
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        try {
            flag = warehouse.sellMerchandise("Televisor","Neo", 430);
        } catch (WarehouseIsEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(flag);
    }

    @Test
    public void wantedMerchandiseNotFoundInWarehouse(){
        boolean flag = true;
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        try {
            flag = warehouse.sellMerchandise("Microwave","Bosch",80);
        } catch (WarehouseIsEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(flag);
    }

    @Test
    public void sellMerchandiseFromEmptyWarehouse(){
        Warehouse warehouse = new Warehouse();
        try {
            warehouse.sellMerchandise("Televisor","Sony",560);
        } catch (WarehouseIsEmptyException e) {
            e.getMessage();
        }
    }

    /**
    The last two test check for the sortByPriceMethod() in Warehouse
     when there is merchandise and when there is NO merchandise
     */

    @Test
    public void sortWarehouseMerchandiseByPrice(){
        Warehouse warehouse = new Warehouse();
        Warehouse sortedWarehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
            sortedWarehouse.addMerchandise(merch2);
            sortedWarehouse.addMerchandise(merch1);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        warehouse.sortByPrice();
        Merchandise temp = warehouse.getMerchandiseAtPosition(0);
        Merchandise sortedTemp = sortedWarehouse.getMerchandiseAtPosition(0);
        assertEquals(temp.getType(), sortedTemp.getType());
        assertEquals(temp.getModel(), sortedTemp.getModel());
        assertEquals(temp.getPrice(), sortedTemp.getPrice());
    }

    @Test
    public void sortEmptyWarehouseMerchandiseByPrice(){
        Warehouse warehouse = new Warehouse();
        warehouse.sortByPrice();
    }
}
