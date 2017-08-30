package com.tw;

//Responsible for adding two operands
public class Addition implements BinaryOperation {

    private final Operand augend;
    private final Operand addend;

    Addition(Operand augend, Operand addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Operand evaluate() {
        int result = this.augend.value() + this.addend.value();
        return new Operand(result);
    }

}
