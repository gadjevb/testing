package com.clouway.testing.task3;

public class WarehouseIsFullException extends Exception {
    public WarehouseIsFullException(){
        super();
    }

    @Override
    public String getMessage(){
        return "No more space for merchandise in warehouse!";
    }
}
