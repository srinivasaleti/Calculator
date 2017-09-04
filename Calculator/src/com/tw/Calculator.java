package com.tw;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
        Stack<Operand> operandStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();
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
        return !operatorStack.empty() && hasPrecedence(currentOperator.symbol(), operatorStack.peek().symbol());
    }

    private void doArithmeticOperation(Stack<Operand> operandStack, Stack<Operator> operatorStack) {
        Operand firstOperand = operandStack.pop();
        Operand secondOperand = operandStack.pop();
        BinaryOperation operation = binaryOperationFactory.getOperation(operatorStack.pop(), secondOperand, firstOperand);
        operandStack.push(operation.evaluate());
    }

    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

}
