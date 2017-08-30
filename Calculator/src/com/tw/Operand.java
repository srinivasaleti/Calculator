package com.tw;

//Represents a arithmetic operand
class Operand {

    private int value;

    Operand(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Operand that = (Operand) object;
        return this.value == that.value;
    }

}
