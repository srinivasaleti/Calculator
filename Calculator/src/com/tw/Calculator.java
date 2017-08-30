package com.tw;

import java.util.List;

//Represents a tool for mathematical calculations
class Calculator {

    private final Expression expression;

    Calculator(Expression expression) {
        this.expression = expression;
    }

    int evaluate() {
        List<Operand> operands = this.expression.operandList();
        List<Operator> operators = this.expression.operatorList();
        return evaluateBasedOn(operands, operators);
    }

    private int evaluateBasedOn(List<Operand> operands, List<Operator> operators) {
        return 0;
    }

}
