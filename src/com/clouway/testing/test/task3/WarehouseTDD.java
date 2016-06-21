package com.clouway.testing.test.task3;

import com.clouway.testing.task3.*;
import static org.junit.Assert.*;
import org.junit.*;

public class WarehouseTDD {

    @Test
    public void createWarehouseObject(){
        Warehouse warehouse = new Warehouse();
        assertNotNull(warehouse);
    }

    @Test
    public void addMerchendiseToWarehouse() {
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


    @Test(expected = IndexOutOfBoundsException.class)
    public void getNonExistMerchandise(){
        Warehouse warehouse = new Warehouse();
        warehouse.getMerchandiseAtPosition(0);
    }

}
