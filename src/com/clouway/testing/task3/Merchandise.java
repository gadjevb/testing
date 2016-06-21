package com.clouway.testing.task3;

public class Merchandise {
    private String type;
    private String model;
    protected int price;

    public Merchandise(String type, String model, int price){
        this.type = type;
        this.model = model;
        this.price = price;
    }

    public String getType(){
        return type;
    }

    public String getModel(){
        return model;
    }

    public int getPrice(){
        return price;
    }
}
