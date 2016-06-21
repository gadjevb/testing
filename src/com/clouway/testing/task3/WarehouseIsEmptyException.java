package com.clouway.testing.task3;

public class WarehouseIsEmptyException extends Exception {
    public WarehouseIsEmptyException(){
        super();
    }

    @Override
    public String getMessage(){
        return "Warehouse is empty, there is nothing to sell!";
    }
}
