package com.tw;

//Responsible for division of two operands
public class Division implements BinaryOperation {

    private static final int ZERO = 0;

    private final Operand nominator;
    private final Operand denominator;

    Division(Operand nominator, Operand denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public Operand evaluate() {
        if (denominator.value() == ZERO) {
            throw new ArithmeticException("Denominator is zero");
        }
        int result = this.nominator.value() / this.denominator.value();
        return new Operand(result);
    }

}
