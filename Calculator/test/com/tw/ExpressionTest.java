package com.tw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void singleOperand() {
        String representation = "1";
        Expression expression = new Expression(representation);
        Operand[] operands = {new Operand(1)};

        Assertions.assertArrayEquals(operands, expression.operandList().toArray());
    }

    @Test
    void listOfOperandsInGivenExpression() {
        String representation = "1+12";
        Expression expression = new Expression(representation);
        Operand[] operands = {new Operand(1), new Operand(12)};

        Assertions.assertArrayEquals(operands, expression.operandList().toArray());
    }

}