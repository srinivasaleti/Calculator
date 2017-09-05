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
        Calculator calculator = new Calculator(new BinaryOperationFactory(), new OperatorPrecedenceFactory());

        assertEquals(0, calculator.evaluate(expression));
    }

    @Test
    void shouldReturnThree() {
        String representation = "2*1+1";
        Expression expression = new Expression(representation);
        Calculator calculator = new Calculator(new BinaryOperationFactory(), new OperatorPrecedenceFactory());

        assertEquals(3, calculator.evaluate(expression));
    }

    @Test
    void askExpressionForListOfOperandsToEvaluateIt() {
        Expression expression = mock(Expression.class);
        Calculator calculator = new Calculator(new BinaryOperationFactory(), new OperatorPrecedenceFactory());
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
        Calculator calculator = new Calculator(new BinaryOperationFactory(), new OperatorPrecedenceFactory());
        Operand aOperand = new Operand(1);
        char PLUS = '+';
        Operator aOperator = new Operator(PLUS);

        when(expression.operandList()).thenReturn(Collections.singletonList(aOperand));
        when(expression.operatorList()).thenReturn(Collections.singletonList(aOperator));
        calculator.evaluate(expression);

        verify(expression).operatorList();
    }

    @Test
    void askBinaryFactoryToGetOperation() {
        String representation = "2+3*4";
        char Product = '*';
        char plus = '+';
        Expression expression = new Expression(representation);
        BinaryOperationFactory binaryOperationFactory = mock(BinaryOperationFactory.class);
        Calculator calculator = new Calculator(binaryOperationFactory, new OperatorPrecedenceFactory());
        Multiplication multiplication = mock(Multiplication.class);
        BinaryOperation addOperation = mock(Addition.class);

        when(binaryOperationFactory.getOperation(any(Operator.class), any(Operand.class), any(Operand.class)))
                .thenReturn(multiplication);
        when(addOperation.evaluate()).thenReturn(new Operand(14));
        when(multiplication.evaluate()).thenReturn(new Operand(12));
        calculator.evaluate(expression);

        verify(binaryOperationFactory).getOperation(new Operator(Product), new Operand(3), new Operand(4));
        verify(binaryOperationFactory).getOperation(new Operator(plus), new Operand(2), new Operand(12));
    }

    @Test
    void executeOperationGotFromBinaryFactory() {
        String representation = "2+4*3";
        Expression expression = new Expression(representation);
        BinaryOperationFactory binaryOperationFactory = mock(BinaryOperationFactory.class);
        Calculator calculator = new Calculator(binaryOperationFactory, new OperatorPrecedenceFactory());
        BinaryOperation addOperation = mock(Addition.class);

        when(binaryOperationFactory.getOperation(any(Operator.class), any(Operand.class), any(Operand.class)))
                .thenReturn(addOperation, addOperation);
        when(addOperation.evaluate()).thenReturn(new Operand(1));
        calculator.evaluate(expression);

        verify(addOperation, times(2)).evaluate();
    }
    
}
