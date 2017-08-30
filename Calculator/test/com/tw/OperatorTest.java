package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OperatorTest {

    @Test
    void operatorIsNotEqualToNull() {
        char symbol = '+';
        Operator operator = new Operator(symbol);

        assertNotEquals(null, operator);
    }

    @Test
    void operatorIsEqualToItself() {
        char symbol = '+';
        Operator operator = new Operator(symbol);

        assertEquals(operator, operator);
    }

    @Test
    void operatorIsNotEqualToString() {
        char symbol = '+';
        Operator operator = new Operator(symbol);
        String unexpected = "operator";

        assertNotEquals(unexpected, operator);

    }

    @Test
    void operatorIsEqualToSameOperator() {
        char symbol = '+';
        Operator operator = new Operator(symbol);
        Operator sameOperator = new Operator(symbol);

        assertEquals(operator, sameOperator);
    }

    @Test
    void expectedPlusSymbol() {
        char plus = '+';
        Operator operator = new Operator(plus);

        assertEquals(plus, operator.symbol());
    }

    @Test
    void expectedMinusSymbol() {
        char minus = '-';
        Operator operator = new Operator(minus);

        assertEquals(minus, operator.symbol());
    }

}