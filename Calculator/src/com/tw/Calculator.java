package com.tw;

import java.util.Iterator;
import java.util.List;

//Represents a tool for mathematical calculations
class Calculator {

    private final BinaryOperationFactory binaryOperationFactory;

    Calculator(BinaryOperationFactory binaryOperationFactory) {
        this.binaryOperationFactory = binaryOperationFactory;
    }

    int evaluate(Expression expression) {
        List<Operand> operands = expression.operandList();
        List<Operator> operators = expression.operatorList();
        return evaluateBasedOn(operands.iterator(), operators.iterator());
    }

    private int evaluateBasedOn(Iterator<Operand> operands, Iterator<Operator> operators) {
        Operand resultOperand = operands.next();
        while (operands.hasNext() && operators.hasNext()) {
            BinaryOperation operation = binaryOperationFactory.getOperation(operators.next(), resultOperand, operands.next());
            resultOperand = operation.evaluate();
        }
        return resultOperand.value();
    }

}
