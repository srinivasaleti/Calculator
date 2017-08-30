package com.tw;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorTest {

    @Test
    void shouldReturnZero() {
        Expression expression = new Expression("0");
        Calculator calculator = new Calculator(expression, new BinaryOperationFactory());

        assertEquals(0, calculator.evaluate());
    }

    @Test
    void shouldReturnThree() {
        Expression expression = new Expression("2-1+2*2/2");
        Calculator calculator = new Calculator(expression, new BinaryOperationFactory());

        assertEquals(3, calculator.evaluate());
    }

    @Test
    void askExpressionForListOfOperandsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(expression, new BinaryOperationFactory());

        when(expression.operandList()).thenReturn(Collections.singletonList(new Operand(1)));
        when(expression.operatorList()).thenReturn(Collections.singletonList(new Operator('+')));
        calculator.evaluate();

        verify(expression).operandList();
    }

    @Test
    void askExpressionForListOfOperatorsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(expression, new BinaryOperationFactory());

        when(expression.operandList()).thenReturn(Collections.singletonList(new Operand(1)));
        when(expression.operatorList()).thenReturn(Collections.singletonList(new Operator('+')));
        calculator.evaluate();

        verify(expression).operatorList();
    }

}
