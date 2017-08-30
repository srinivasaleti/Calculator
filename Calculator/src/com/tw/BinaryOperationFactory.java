package com.tw;

//Responsible for performing proper operation
class BinaryOperationFactory {

    BinaryOperation getOperation(Operator operator, Operand firstOperand, Operand secondOperand) {
        if (operator.equals(new Operator('+'))) {
            return new Addition(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator('-'))) {
            return new Subtraction(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator('*'))) {
            return new Multiplication(firstOperand, secondOperand);
        }
        if (operator.equals(new Operator('/'))) {
            return new Division(firstOperand, secondOperand);
        }
        throw new InvalidOperationException("Invalid Operation");
    }

}