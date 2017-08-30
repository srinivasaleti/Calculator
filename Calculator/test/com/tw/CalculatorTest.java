package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void shouldReturnZero() {
        Expression expression = new Expression("0");
        Calculator calculator = new Calculator(expression);

        assertEquals(0, calculator.evaluate());
    }

    @Test
    void shouldReturnThree() {
        Expression expression = new Expression("1+2");
        Calculator calculator = new Calculator(expression);

        assertEquals(3, calculator.evaluate());
    }

}
