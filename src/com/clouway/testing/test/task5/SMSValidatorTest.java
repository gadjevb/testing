package com.clouway.testing.test.task5;


import com.clouway.testing.task5.SMS;
import com.clouway.testing.task5.SMSValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class SMSValidatorTest {
    SMSValidator validator = new SMSValidator();

    public String veryLongString(int length){
        String temp = "";
        for(int i = 0; i <= length; i++){
            temp = temp + "A";
        }
        return temp;
    }

    @Test
    public void validSms(){ //Happy path!
        assertTrue(validator.isSmsValid(new SMS("0878884433","Work","When should I start?")));
    }

    @Test
    public void smsIsWithoutANumber(){
        assertFalse(validator.isSmsValid(new SMS("","Work","When should I start?")));
    }

    @Test
    public void smsIsWithoutATitle(){
        assertFalse(validator.isSmsValid(new SMS("0878884433","","When should I start?")));
    }

    @Test
    public void smsIsWithoutABody(){
        assertFalse(validator.isSmsValid(new SMS("0878884433","Work","")));
    }

    @Test
    public void textInSmsBodyIsWithIncorrectLength(){
        String longBodyMessage = veryLongString(101);
        assertFalse(validator.isSmsValid(new SMS("0878884433","Work",longBodyMessage)));
    }

    @Test
    public void textInSmsTitleIsWithIncorrectLength(){
        String flag = veryLongString(31);
        assertFalse(validator.isSmsValid(new SMS("0878884433",flag,"Hello there!")));
    }

}
