package com.company;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {
    private static Calculator calculator;
    private static String opString1;
    private static String opString2;
    private static String opString3;
    private static String opString4;
    private static String opString5;
    private static String opString6;


    @BeforeAll
    static void before(){
        calculator = new Calculator();
        opString1 = "5 + 4";
        opString2 = "5 - 4";
        opString3 = "5 / 4";
        opString4 = "5 : 4";
        opString5 = "5 * 4";
        opString6 = "5 x 4";
    }

    @org.junit.jupiter.api.Test
    void parseOperation() {
        assertTrue(calculator.parseOperation(opString1));
        assertTrue(calculator.parseOperation(opString2));
        assertTrue(calculator.parseOperation(opString3));
        assertTrue(calculator.parseOperation(opString4));
        assertTrue(calculator.parseOperation(opString5));
        assertTrue(calculator.parseOperation(opString6));
    }

    @org.junit.jupiter.api.Test
    void getResult() {
        //5 + 4
        assertTrue(calculator.parseOperation(opString1));
        assertEquals(calculator.getResult(),  5 + 4);

        //5 - 4
        assertTrue(calculator.parseOperation(opString2));
        assertEquals(calculator.getResult(), 5 - 4);

        //5 / 4
        assertTrue(calculator.parseOperation(opString3));
        assertEquals(calculator.getResult(), 5.00 / 4.00);

        //5 : 4
        assertTrue(calculator.parseOperation(opString4));
        assertEquals(calculator.getResult(), 5.00 / 4.00);

        //5 * 4
        assertTrue(calculator.parseOperation(opString5));
        assertEquals(calculator.getResult(), 5 * 4);

        //5 x 4
        assertTrue(calculator.parseOperation(opString6));
        assertEquals(calculator.getResult(), 5 * 4);
    }
}