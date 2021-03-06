package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionTest {

    @Test
    void throwExceptionWhenDenominatorIsZero() {
        Operand nominator = new Operand(2);
        Operand denominator = new Operand(0);
        BinaryOperation operation = new Division(nominator, denominator);

        assertThrows(ArithmeticException.class, operation::evaluate);
    }

    @Test
    void fourByOneIsEqualToFour() {
        Operand nominator = new Operand(4);
        Operand denominator = new Operand(1);
        Operand expected = new Operand(4);
        BinaryOperation operation = new Division(nominator, denominator);

        assertEquals(expected, operation.evaluate());
    }

    @Test
    void fourByTwoIsEqualToTwo() {
        Operand nominator = new Operand(4);
        Operand denominator = new Operand(2);
        Operand expected = new Operand(2);
        BinaryOperation operation = new Division(nominator, denominator);

        assertEquals(expected, operation.evaluate());
    }

}