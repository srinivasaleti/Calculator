package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtractionTest {

    @Test
    void zeroMinusZeroIsZero() {
        Operand minuend = new Operand(0);
        Operand subtrahend = new Operand(0);
        Operand expected = new Operand(0);
        BinaryOperation operation = new Subtraction(minuend, subtrahend);

        assertEquals(expected, operation.evaluate());
    }

    @Test
    void twoMinusOneIsOne() {
        Operand minuend = new Operand(2);
        Operand subtrahend = new Operand(1);
        Operand expected = new Operand(1);
        BinaryOperation operation = new Subtraction(minuend, subtrahend);

        assertEquals(expected, operation.evaluate());
    }

}