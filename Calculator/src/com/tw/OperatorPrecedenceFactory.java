package com.tw;

//Represents a factory which gives precedence
class OperatorPrecedenceFactory {

    private static final Operator ADDITIVE_OPERATOR = new Operator('+');
    private static final Operator SUBTRACTIVE_OPERATOR = new Operator('-');
    private static final Operator MULTIPLICATIVE_OPERATOR = new Operator('/');
    private static final Operator DIVISION_OPERATOR = new Operator('*');

    private static final Precedence ADDITIVE_SUBTRACTIVE_PRECEDENCE = new Precedence(1);
    private static final Precedence DIVISION_MULTIPLICATIVE_PRECEDENCE = new Precedence(2);
    private static final Precedence MINIMUM_PRECEDENCE = new Precedence(0);

    Precedence getPrecedence(Operator operator) {
        if (operator.equals(ADDITIVE_OPERATOR)) {
            return ADDITIVE_SUBTRACTIVE_PRECEDENCE;
        }
        if (operator.equals(SUBTRACTIVE_OPERATOR)) {
            return ADDITIVE_SUBTRACTIVE_PRECEDENCE;
        }
        if (operator.equals(MULTIPLICATIVE_OPERATOR)) {
            return DIVISION_MULTIPLICATIVE_PRECEDENCE;
        }
        if (operator.equals(DIVISION_OPERATOR)) {
            return DIVISION_MULTIPLICATIVE_PRECEDENCE;
        }
        return MINIMUM_PRECEDENCE;
    }

}
