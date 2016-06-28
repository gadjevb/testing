package com.clouway.testing.test.task4;

import com.clouway.testing.task4.StartsWithKeyWord;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartsWithKeyWordTest {


    @Test
    public void keywordIsStartingWithProvidedKeyword(){ //Happy path
        assertTrue(new StartsWithKeyWord("/user/Pictures").matches("/user/"));
    }


    @Test
    public void keywordIsNotStartingWithProvidedKeyword(){
        assertFalse(new StartsWithKeyWord("/employee/Pictures").matches("/user/"));

    }
}
