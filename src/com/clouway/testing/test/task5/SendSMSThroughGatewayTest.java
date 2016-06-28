package com.clouway.testing.test.task5;

import com.clouway.testing.task5.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class SendSMSThroughGatewayTest {
    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
    Validator validator = context.mock(Validator.class);
    Sender sender = context.mock(Sender.class);
    Gateway gateway = new Gateway(validator, sender);

    @Test
    public void successfulSendingOfSmsThroughGateway() throws ErrorWhileTryingToSendSMSException { //Happy path!
        SMS correctSms = new SMS("0876560220","Hello!","Hi Borislav, my name is John!");
        context.checking(new Expectations(){{
            oneOf(validator).isSmsValid(correctSms);
            will(returnValue(true));

            oneOf(sender).sendSMS(correctSms);
            will(returnValue(true));
        }});
        gateway.sendSMS(correctSms);
    }

    @Test
    public void smsValidationFails() throws ErrorWhileTryingToSendSMSException {
        SMS incorrectSMS = new SMS("","Hello!","Hi Borislav, my name is John!");
        context.checking(new Expectations(){{
            oneOf(validator).isSmsValid(incorrectSMS);
            will(returnValue(false));
        }});
        gateway.sendSMS(incorrectSMS);
    }

    @Test(expected = ErrorWhileTryingToSendSMSException.class)
    public void sendingThroughGatewayFails() throws ErrorWhileTryingToSendSMSException {
        SMS correctSms = new SMS("0876560220","Hello!","Hi Borislav, my name is John!");
        context.checking(new Expectations(){{
            oneOf(validator).isSmsValid(correctSms);
            will(returnValue(true));

            oneOf(sender).sendSMS(correctSms);
            will(returnValue(false));
        }});
        gateway.sendSMS(correctSms);
    }
}
