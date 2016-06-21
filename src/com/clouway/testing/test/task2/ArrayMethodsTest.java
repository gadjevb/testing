package com.clouway.testing.test.task2;

import com.clouway.testing.task2.ArrayMethods;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayMethodsTest {

    @Test
    public void getMinElement(){
        ArrayMethods testTool = new ArrayMethods();
        int arr[] = {5,1,9,2,6,3,4,8,7,0};
        assertEquals(0,testTool.getMinElement(arr));
    }

    @Test
    public void getSumOfArrayElements(){
        ArrayMethods testTool = new ArrayMethods();
        int arr[] = {5,1,9,2,6,3,4,8,7,0};
        assertEquals(45,testTool.getSumOfArrayElements(arr));
    }

    @Test
    public void printArray(){
        int arr[] = {5,1,9,2,6,3,4,8,7,0};
        ArrayMethods testTool = new ArrayMethods();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        testTool.printArray(arr);
        assertEquals("5 1 9 2 6 3 4 8 7 0 ", output.toString());
    }

    @Test
    public void sortArray(){
        ArrayMethods testTool = new ArrayMethods();
        int arr[] = {5,1,9,2,6,3,4,8,7,0};
        int sortedArr[] = {0,1,2,3,4,5,6,7,8,9};
        testTool.sortArray(arr, 0, arr.length - 1);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    public void reverseArray(){
        ArrayMethods testTool = new ArrayMethods();
        int arr[] = {5,1,9,2,6,3,4,8,7,0};
        int reversedArr[] = {0,7,8,4,3,6,2,9,1,5};
        testTool.reverseArray(arr);
        assertArrayEquals(reversedArr, arr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMinElementOfNullArray(){
        ArrayMethods testTool = new ArrayMethods();
        int emptyArr[] = new int[0];
        testTool.getMinElement(emptyArr);
    }

}
