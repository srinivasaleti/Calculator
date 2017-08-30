package com.tw;

//Responsible for performing proper operation
class BinaryOperationFactory {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char PRODUCT = '*';
    private static final char DIVISION = '/';

    BinaryOperation getOperation(Operator operator, Operand firstOperand, Operand secondOperand) {
        if (operator.equals(new Operator(PLUS))) {
            return new Addition(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator(MINUS))) {
            return new Subtraction(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator(PRODUCT))) {
            return new Multiplication(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator(DIVISION))) {
            return new Division(firstOperand, secondOperand);
        }
        throw new InvalidOperationException("Invalid Operation");
    }

}