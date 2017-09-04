package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExpressionTest {

    @Test
    void expectedSingleOperandInGivenExpression() {
        String representation = "1";
        Expression expression = new Expression(representation);
        Operand[] operands = {new Operand(1)};

        assertArrayEquals(operands, expression.operandList().toArray());
    }

    @Test
    void expectedListOfOperandsInGivenExpression() {
        String representation = "1+12";
        Expression expression = new Expression(representation);
        Operand[] operands = {new Operand(1), new Operand(12)};

        assertArrayEquals(operands, expression.operandList().toArray());
    }

    @Test
    void expectedSingleOperatorInGivenExpression() {
        Expression expression = new Expression("1+2");
        Operator[] operators = {new Operator('+')};

        assertArrayEquals(operators, expression.operatorList().toArray());
    }

    @Test
    void expectedAllOperatorsInExpressions() {
        Expression expression = new Expression("1+2-3");
        Operator[] operators = {new Operator('+'), new Operator('-')};

        assertArrayEquals(operators, expression.operatorList().toArray());
    }

}