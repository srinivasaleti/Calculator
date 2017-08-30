package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OperandTest {

    @Test
    void operandIsNotEqualToNull() {
        Operand operand = new Operand(0);

        assertNotEquals(null, operand);
    }

    @Test
    void operandIsEqualToItself() {
        Operand operand = new Operand(0);

        assertEquals(operand, operand);
    }

    @Test
    void operandIsNotEqualToString() {
        Operand operand = new Operand(0);
        String unexpected = "operand";

        assertNotEquals(unexpected, operand);
    }

    @Test
    void operandIsEqualToSameOperand() {
        Operand operand = new Operand(0);
        Operand sameOperand = new Operand(0);

        assertEquals(operand, sameOperand);
    }

    @Test
    void expectedZero() {
        int zero = 0;
        Operand operand = new Operand(zero);

        assertEquals(zero, operand.value());
    }

    @Test
    void expectedOne() {
        int one = 1;
        Operand operand = new Operand(1);

        assertEquals(one, operand.value());
    }

}