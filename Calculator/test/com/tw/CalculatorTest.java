package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    @Test
    void askExpressionForListOfOperandsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(expression);

        calculator.evaluate();

        verify(expression).operandList();
    }

    @Test
    void askExpressionForListOfOperatorsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(expression);

        calculator.evaluate();

        verify(expression).operatorList();
    }

}
