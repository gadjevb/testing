package com.clouway.testing.task5;

public class Gateway {
    private Validator validator;
    private Sender sender;

    public Gateway(Validator validator, Sender sender){
        this.validator = validator;
        this.sender = sender;
    }

    public void sendSMS(SMS sms) throws ErrorWhileTryingToSendSMSException {
        if(validator.isSmsValid(sms)){
            if(!sender.sendSMS(sms)){
                throw new ErrorWhileTryingToSendSMSException();
            }
        }
    }
}
