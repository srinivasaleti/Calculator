package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {

    @Test
    void zeroPlusZeroIsZero() {
        Operand augend = new Operand(0);
        Operand addend = new Operand(0);
        BinaryOperation operation = new Addition(augend,addend);

        assertEquals(new Operand(0), operation.evaluate());
    }

    @Test
    void onePlusTwoIsThree() {
        Operand augend = new Operand(1);
        Operand addend = new Operand(2);
        BinaryOperation operation = new Addition(augend,addend);

        assertEquals(new Operand(3), operation.evaluate());
    }

}