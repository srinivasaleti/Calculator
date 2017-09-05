package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PrecedenceTest {

    private Precedence precedence;

    @BeforeEach
    void setUp() {
        this.precedence = new Precedence(1);
    }

    @Test
    void precedenceIsNotEqualToNull() {
        assertNotEquals(null, this.precedence);
    }

    @Test
    void precedenceIsNotEqualToString() {
        assertNotEquals("Precedence", this.precedence);
    }

    @Test
    void precedenceIsEqualToItSelf() {
        assertEquals(this.precedence, this.precedence);
    }

    @Test
    void precedenceIsEqualToSamePrecedence() {
        Precedence precedence = new Precedence(1);
        assertEquals(precedence, this.precedence);
    }

}
