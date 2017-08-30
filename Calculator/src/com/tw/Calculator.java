package com.tw;

import java.util.Iterator;
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
        return evaluateBasedOn(operands.iterator(), operators.iterator());
    }

    private int evaluateBasedOn(Iterator<Operand> operands, Iterator<Operator> operators) {
        return 0;
    }

}
