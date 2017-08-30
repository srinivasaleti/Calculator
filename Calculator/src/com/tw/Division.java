package com.tw;

//Responsible for division of two operands
public class Division implements BinaryOperation {

    private static final int ZERO = 0;
    private static final String DENOMINATOR_IS_ZERO = "Denominator is zero";

    private final Operand nominator;
    private final Operand denominator;

    Division(Operand nominator, Operand denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public Operand evaluate() {
        if (denominator.value() == ZERO) {
            throw new ArithmeticException(DENOMINATOR_IS_ZERO);
        }
        int result = this.nominator.value() / this.denominator.value();
        return new Operand(result);
    }

}
