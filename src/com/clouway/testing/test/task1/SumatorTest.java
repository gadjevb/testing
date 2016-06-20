package com.clouway.testing.test.task1;

import com.clouway.testing.task1.Sumator;
import static org.junit.Assert.*;
import org.junit.*;

public class SumatorTest {

    Sumator addition;

    @Before
    public void setup(){
        addition = new Sumator();
    }

    @Test
    public void correctSumOfStringsTest(){
        assertEquals(11,addition.sumStrings("5","6"));
    }

    @Test(expected = NumberFormatException.class)
    public void numberFormatExceptionTest(){
        addition.sumStrings("a12","11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest(){
        addition.sumStrings(null,"3");
    }
}
