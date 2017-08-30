package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinaryOperationFactoryTest {

    private BinaryOperationFactory binaryOperationFactory;

    @BeforeEach
    void beforeEach() {
        this.binaryOperationFactory = new BinaryOperationFactory(new Operand(1), new Operand(2));
    }

    @Test
    void expectedAdditionOperation() {
        assertEquals(Addition.class, this.binaryOperationFactory.getOperation(new Operator('+')).getClass());
    }

    @Test
    void expectedSubtractionOperation() {
        assertEquals(Subtraction.class, this.binaryOperationFactory.getOperation(new Operator('-')).getClass());
    }

    @Test
    void expectedMultiplicationOperation() {
        assertEquals(Multiplication.class, this.binaryOperationFactory.getOperation(new Operator('*')).getClass());
    }

    @Test
    void expectedDivisionOperation() {
        assertEquals(Division.class, this.binaryOperationFactory.getOperation(new Operator('/')).getClass());
    }

    @Test
    void throwsExceptionIfNotAValidOperator() {
        assertThrows(InvalidOperationException.class, () -> this.binaryOperationFactory.getOperation(new Operator('k')));
    }

}