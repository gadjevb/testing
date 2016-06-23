package com.clouway.testing.task3;

public class Merchandise {
    private String type;
    private String model;
    private int quantity;
    protected int price;

    public Merchandise(String type, String model, int price, int quantity){
        this.type = type;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Overriding for the equals() method so that it can compare Merchandise objects.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchandise)) return false;

        Merchandise that = (Merchandise) o;

        if (price != that.price) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return model != null ? model.equals(that.model) : that.model == null;

    }
}
