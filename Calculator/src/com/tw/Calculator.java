package com.tw;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//Represents a tool for mathematical calculations
class Calculator {

    private final BinaryOperationFactory binaryOperationFactory;
    private final OperatorPrecedenceFactory operatorPrecedenceFactory;

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    Calculator(BinaryOperationFactory binaryOperationFactory, OperatorPrecedenceFactory operatorPrecedenceFactory) {
        this.binaryOperationFactory = binaryOperationFactory;
        this.operatorPrecedenceFactory = operatorPrecedenceFactory;
        this.operandStack = new Stack<>();
        this.operatorStack = new Stack<>();
    }

    int evaluate(Expression expression) {
        List<Operand> operands = expression.operandList();
        List<Operator> operators = expression.operatorList();
        return evaluateBasedOn(operands.iterator(), operators.iterator());
    }

    private int evaluateBasedOn(Iterator<Operand> operands, Iterator<Operator> operators) {
        if (!operands.hasNext()) {
            return 0;
        }
        operandStack.push(operands.next());
        while (operands.hasNext()) {
            Operator currentOperator = operators.next();
            while (canPerformOperation(operatorStack, currentOperator)) {
                doArithmeticOperation(operandStack, operatorStack);
            }
            operandStack.push(operands.next());
            operatorStack.push(currentOperator);
        }
        while (!operatorStack.empty()) {
            doArithmeticOperation(operandStack, operatorStack);
        }
        return operandStack.peek().value();
    }

    private boolean canPerformOperation(Stack<Operator> operatorStack, Operator currentOperator) {
        if (operatorStack.empty()) {
            return false;
        }
        Operator stackTopOperator = operatorStack.peek();
        Precedence stackTopOperatorPrecedence = this.operatorPrecedenceFactory.getPrecedence(stackTopOperator);
        Precedence currentOperatorPrecedence = this.operatorPrecedenceFactory.getPrecedence(currentOperator);
        return stackTopOperatorPrecedence.hasHigherThan(currentOperatorPrecedence);
    }

    private void doArithmeticOperation(Stack<Operand> operandStack, Stack<Operator> operatorStack) {
        Operand firstOperand = operandStack.pop();
        Operand secondOperand = operandStack.pop();
        BinaryOperation operation = binaryOperationFactory.getOperation(operatorStack.pop(), secondOperand, firstOperand);
        operandStack.push(operation.evaluate());
    }

}
