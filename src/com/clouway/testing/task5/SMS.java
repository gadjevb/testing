package com.clouway.testing.task5;

public class SMS {
    private String number = "", title = "", text = "";

    public SMS(String number, String title, String text) {
        this.number = number;
        this.title = title;
        this.text = text;
    }

    public boolean isWithoutNumber(){
        if(number.length() != 10){
            return true;
        }else{
            return false;
        }
    }

    public boolean isWithoutTitle() {
        if(title.length() == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isWithoutBody() {
        if(text.length() == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean bodyIsWithIncorrectLength() {
        if(text.length() < 10 || text.length() > 100){
            return true;
        }else{
            return false;
        }
    }

    public boolean titleIsWithIncorrectLength() {
        if(title.length() > 30){
            return true;
        }else{
            return false;
        }
    }
}
