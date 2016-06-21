package com.clouway.testing.test.task2;

import com.clouway.testing.task2.ArrayMethods;
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayMethodsTest {
    int arr[];
    int sortedArr[];
    int reversedArr[];
    int emptyArr[];
    ArrayMethods testTool;

    @Before
    public void setup(){
        arr = new int[]{5,1,9,2,6,3,4,8,7,0};
        sortedArr = new int[]{0,1,2,3,4,5,6,7,8,9};
        reversedArr = new int[]{0,7,8,4,3,6,2,9,1,5};
        testTool = new ArrayMethods();
    }

    @Test(timeout = 1000)
    public void getMinElementTest(){
        assertEquals(0,testTool.getMinElement(arr));
    }

    @Test(timeout = 1000)
    public void getSumOfArrayElementsTest(){
        assertEquals(45,testTool.getSumOfArrayElements(arr));
    }

    @Test(timeout = 1000)
    public void printArrayTest(){
        assertEquals("5 1 9 2 6 3 4 8 7 0 ",testTool.printArray(arr));
    }

    @Test(timeout = 1000)
    public void sortArrayTest(){
        testTool.sortArray(arr, 0, arr.length - 1);
        assertArrayEquals(sortedArr, arr);
    }

    @Test(timeout = 1000)
    public void reverseArrayTest(){
        testTool.reverseArray(arr);
        assertArrayEquals(reversedArr, arr);
    }

    @Test(expected = NullPointerException.class)
    public void arrayNullPointerExceptionTest(){
        testTool.getMinElement(emptyArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsExceptionTest(){
        testTool.getElement(arr, 15);
    }

    @After
    public void teardown(){
        arr = null;
        sortedArr = null;
        reversedArr = null;
        testTool = null;
    }
}
