package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorPrecedenceFactoryTest {

    private OperatorPrecedenceFactory operatorPrecedenceFactory;

    @BeforeEach
    void setUp() {
        this.operatorPrecedenceFactory = new OperatorPrecedenceFactory();
    }

    @Test
    void expectedPrecedenceOfAdditiveOperator() {
        Precedence precedence = new Precedence(1);
        Operator operator = new Operator('+');
        assertEquals(precedence, this.operatorPrecedenceFactory.getPrecedence(operator));
    }

    @Test
    void expectedPrecedenceOfSubtractiveOperator() {
        Precedence precedence = new Precedence(1);
        Operator operator = new Operator('-');
        assertEquals(precedence, this.operatorPrecedenceFactory.getPrecedence(operator));
    }

    @Test
    void expectedPrecedenceOfMultiplicativeOperator() {
        Precedence precedence = new Precedence(2);
        Operator operator = new Operator('*');
        assertEquals(precedence, this.operatorPrecedenceFactory.getPrecedence(operator));
    }

    @Test
    void expectedPrecedenceOfDivisionOperator() {
        Precedence precedence = new Precedence(2);
        Operator operator = new Operator('/');
        assertEquals(precedence, this.operatorPrecedenceFactory.getPrecedence(operator));
    }

    @Test
    void expectedMinimumPrecedence() {
        Precedence precedence = new Precedence(0);
        Operator operator = new Operator('i');
        assertEquals(precedence, this.operatorPrecedenceFactory.getPrecedence(operator));
    }

}