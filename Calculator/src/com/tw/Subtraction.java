package com.tw;

//Responsible for subtracting two operands
public class Subtraction implements BinaryOperation {

    private final Operand minuend;
    private final Operand subtrahend;

    Subtraction(Operand minuend, Operand subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public Operand evaluate() {
        int result = this.minuend.value() - this.subtrahend.value();
        return new Operand(result);
    }

}
