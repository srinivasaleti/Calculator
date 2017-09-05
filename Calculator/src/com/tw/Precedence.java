package com.tw;

//Represents precedence
class Precedence {

    private final int value;

    Precedence(int value) {
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
        Precedence that = (Precedence) object;
        return this.value == that.value;
    }

    boolean hasHigherThan(Precedence precedence) {
        return this.value >= precedence.value();
    }

    int value() {
        return this.value;
    }

}
