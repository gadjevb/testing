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

    /**
     * Overriding for the equals() method so that it can compare Merchandise objects.
     */

    @Override
    public boolean equals(Object obj){
        Merchandise temp = (Merchandise) obj;

        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        if(this.type == temp.type){
            if(this.model == temp.model){
                if(this.price == temp.price){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
