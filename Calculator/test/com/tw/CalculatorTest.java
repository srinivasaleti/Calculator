package com.tw;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorTest {

    @Test
    void shouldReturnZero() {
        String representation = "0";
        Expression expression = new Expression(representation);
        Calculator calculator = new Calculator(new BinaryOperationFactory());

        assertEquals(0, calculator.evaluate(expression));
    }

    @Test
    void shouldReturnThree() {
        String representation = "2-1+2*2/2";
        Expression expression = new Expression(representation);
        Calculator calculator = new Calculator(new BinaryOperationFactory());

        assertEquals(3, calculator.evaluate(expression));
    }

    @Test
    void askExpressionForListOfOperandsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(new BinaryOperationFactory());
        Operand aOperand = new Operand(1);
        Operator aOperator = new Operator('+');

        when(expression.operandList()).thenReturn(Collections.singletonList(aOperand));
        when(expression.operatorList()).thenReturn(Collections.singletonList(aOperator));
        calculator.evaluate(expression);

        verify(expression).operandList();
    }

    @Test
    void askExpressionForListOfOperatorsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(new BinaryOperationFactory());
        Operand aOperand = new Operand(1);
        Operator aOperator = new Operator('+');

        when(expression.operandList()).thenReturn(Collections.singletonList(aOperand));
        when(expression.operatorList()).thenReturn(Collections.singletonList(aOperator));
        calculator.evaluate(expression);

        verify(expression).operatorList();
    }

}
