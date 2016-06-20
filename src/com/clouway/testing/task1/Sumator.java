package com.clouway.testing.task1;

public class Sumator {

    public int sumStrings(String a, String b) throws NumberFormatException, IllegalArgumentException{

        int operandOne = Integer.parseInt(a);
        int operandTwo = Integer.parseInt(b);

        return operandOne + operandTwo;
    }

}
