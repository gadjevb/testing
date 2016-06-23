package com.clouway.testing.test.task3;

import com.clouway.testing.task3.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import org.junit.*;
import java.util.*;

public class SellProductsFromWarehouseTest {

    /**
     *Adds merchandise to full warehouse, the standard
     *space for Merchandise is 200 units, if we try to add
     *more than 200 an WarehouseIsFullException will be thrown
     */

    @Test(expected = WarehouseIsFullException.class)
    public void addMerchandiseToFullWarehouse() throws WarehouseIsFullException {
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800,210);
        warehouse.addMerchandise(merch1);
    }

    /**
     *Adds and sells merchandise methods are tested in the first two tests when the searched product is found
     *and when the searched product is NOT found. The third test is for the WarehouseIsEmptyException when the user tries to sell
     *merchandise from empty warehouse.
     */

    @Test
    public void addAndSellMerchandise(){
        boolean flag = false;
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800,30);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430,120);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        try {
            flag = warehouse.sellMerchandise("Televisor","Neo", 430, 50);
        } catch (WarehouseIsEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(flag);
        assertEquals(70,warehouse.getMerchandiseAtPosition(1).getQuantity());
    }

    @Test
    public void wantedMerchandiseNotFoundInWarehouse(){
        boolean flag = true;
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800,20);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430,20);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        try {
            flag = warehouse.sellMerchandise("Microwave","Bosch",80,20);
        } catch (WarehouseIsEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(flag);
    }

    @Test
    public void sellMerchandiseFromEmptyWarehouse(){
        Warehouse warehouse = new Warehouse();
        try {
            warehouse.sellMerchandise("Televisor","Sony",560,20);
        } catch (WarehouseIsEmptyException e) {
            e.getMessage();
        }
    }

    /**
     *Sorts the warehouse merchandise by price.
     *Lists is used from the Guava library,
     *equals() is overriden in the Merchandise class.
     */

    @Test
    public void sortWarehouseMerchandiseByPrice(){
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800,10);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430,10);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        List<Merchandise> goods = warehouse.listMerchandiseByPrice();
        assertThat(goods, is(equalTo(
                Lists.newArrayList(
                        new Merchandise("Televisor","Neo",430,10),
                        new Merchandise("Fridge","Bosch",800,10)
                )
        )));
    }
}
