package com.clouway.testing.task5;

public class SMSValidator implements Validator {
    public boolean isSmsValid(SMS sms){

        if(sms.isWithoutNumber()){
            return false;
        }

        if(sms.isWithoutTitle()){
            return false;
        }

        if(sms.isWithoutBody()){
            return false;
        }

        if(sms.bodyIsWithIncorrectLength()){
            return false;
        }

        if(sms.titleIsWithIncorrectLength()){
            return false;
        }

        return true;
    }
}
