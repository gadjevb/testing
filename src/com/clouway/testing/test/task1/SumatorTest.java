package com.clouway.testing.test.task1;

import com.clouway.testing.task1.Sumator;
import static org.junit.Assert.*;
import org.junit.*;

public class SumatorTest {

    @Test
    public void correctSumOfStrings(){
        Sumator addition = new Sumator();
        assertEquals(11,addition.sumStrings("5","6"));
    }

    @Test(expected = NumberFormatException.class)
    public void incorrectArguments(){
        Sumator addition = new Sumator();
        addition.sumStrings("a12","11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentAreNull(){
        Sumator addition = new Sumator();
        addition.sumStrings(null,"3");
    }
}
