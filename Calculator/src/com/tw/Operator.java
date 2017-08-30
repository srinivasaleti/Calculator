package com.tw;

//Represents a binary operator
class Operator {

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

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
        Operator that = (Operator) object;
        return this.symbol == that.symbol;
    }

    char symbol() {
        return this.symbol;
    }

}
