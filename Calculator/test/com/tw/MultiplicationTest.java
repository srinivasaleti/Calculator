package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicationTest {

    @Test
    void productOfZeroZeroIsZero() {
        Operand multiplier = new Operand(0);
        Operand multiplicand = new Operand(0);
        BinaryOperation operation = new Multiplication(multiplier, multiplicand);

        assertEquals(new Operand(0), operation.evaluate());
    }

    @Test
    void productOfTwoAndThreeIsSix() {
        Operand multiplier = new Operand(2);
        Operand multiplicand = new Operand(3);
        BinaryOperation operation = new Multiplication(multiplier, multiplicand);

        assertEquals(new Operand(6), operation.evaluate());
    }

}