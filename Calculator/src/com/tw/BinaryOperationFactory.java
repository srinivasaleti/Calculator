package com.tw;

//Responsible for performing proper operation
class BinaryOperationFactory {

    private final Operand firstOperand;
    private final Operand secondOperand;

    BinaryOperationFactory(Operand firstOperand, Operand secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public BinaryOperation getOperation(Operator operator) {
        if (operator.equals(new Operator('+'))) {
            return new Addition(firstOperand,secondOperand);
        }
        if (operator.equals(new Operator('-'))) {
            return new Subtraction(firstOperand,secondOperand);
        }
        if (operator.equals(new Operator('*'))) {
            return new Multiplication(firstOperand,secondOperand);
        }
        if (operator.equals(new Operator('/'))) {
            return new Division(firstOperand,secondOperand);
        }
        throw new InvalidOperationException("Invalid Operation");
    }

}