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
     *Testing the WarehouseIsFullException
     */

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
     *Testing the sellMerchandise() method when the searched product is found,
     *when the searched product is NOT found and the WarehouseIsEmptyException
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
     *Testing the sortByPriceMethod() in Warehouse
     *when there is merchandise and when there is NO merchandise
     */

    @Test
    public void sortWarehouseMerchandiseByPrice(){
        Warehouse warehouse = new Warehouse();
        Merchandise merch1 = new Merchandise("Fridge","Bosch",800);
        Merchandise merch2 = new Merchandise("Televisor","Neo",430);
        try {
            warehouse.addMerchandise(merch1);
            warehouse.addMerchandise(merch2);
        } catch (WarehouseIsFullException e) {
            e.printStackTrace();
        }
        List<Merchandise> goods = warehouse.listMerchandiseByPrice();
        assertThat(goods, is(equalTo(
                Lists.newArrayList(
                        new Merchandise("Televisor","Neo",430),
                        new Merchandise("Fridge","Bosch",800)
                )
        )));
    }
}
