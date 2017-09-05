package com.tw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void expectedOneAsPrecedenceValue() {
        assertEquals(1, this.precedence.value());
    }

    @Test
    void expectedAnotherPrecedenceValue() {
        int value = 2;
        Precedence precedence = new Precedence(value);

        assertEquals(value, precedence.value());
    }

    @Test
    void expectedTrueWhenPrecedenceIsMoreThanOrEqualToOtherPrecedence() {
        Precedence samePrecedence = new Precedence(1);
        assertTrue(this.precedence.hasHigherThan(samePrecedence));
    }

    @Test
    void expectedFalseWhePrecedenceIsLesserThanOtherPrecedence() {
        Precedence highPrecedence = new Precedence(3);
        assertFalse(this.precedence.hasHigherThan(highPrecedence));
    }

}
