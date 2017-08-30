package com.tw;

//Responsible for multiplication of two operands
class Multiplication implements BinaryOperation {

    private final Operand multiplier;
    private final Operand multiplicand;

    Multiplication(Operand multiplier, Operand multiplicand) {
        this.multiplier = multiplier;
        this.multiplicand = multiplicand;
    }

    @Override
    public Operand evaluate() {
        int result = this.multiplier.value() * this.multiplicand.value();
        return new Operand(result);
    }

}
