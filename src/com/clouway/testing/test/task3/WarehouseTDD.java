package com.clouway.testing.test.task3;

import com.clouway.testing.task3.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class WarehouseTDD {

    /**
     *The first two test check the addMerchandise() method for the Warehouse class
     *and the WarehouseIsFullException
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
     *The next three test check the sellMerchandise() method when the searched product is found,
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
     *The last two test check for the sortByPriceMethod() in Warehouse
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
        assertThat(goods.get(0).getType(), is(equalTo("Televisor")));
        assertThat(goods.get(0).getModel(), is(equalTo("Neo")));
        assertThat(goods.get(0).getPrice(), is(equalTo(430)));
        assertThat(goods.get(1).getType(), is(equalTo("Fridge")));
        assertThat(goods.get(1).getModel(), is(equalTo("Bosch")));
        assertThat(goods.get(1).getPrice(), is(equalTo(800)));
    }

    @Test
    public void sortEmptyWarehouseMerchandiseByPrice(){
        Warehouse warehouse = new Warehouse();
        warehouse.listMerchandiseByPrice();
    }
}
