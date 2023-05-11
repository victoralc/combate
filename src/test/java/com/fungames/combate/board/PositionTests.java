package com.fungames.combate.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTests {

    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.of(8, 4);
    }

    @Test
    void shouldCreateAPositionWithLineAndColumn() {
        assertNotNull(position);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryToCreateAPositionWithNegativeLineNumber() {
        assertThrows(IllegalArgumentException.class, () -> Position.of(-2, 4));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryToCreateAPositionWithNegativeColumnNumber() {
        assertThrows(IllegalArgumentException.class, () -> Position.of(2, -4));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryToCreateAPositionWithLineGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> Position.of(11, 4));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryToCreateAPositionWithColumnGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> Position.of(2, 20));
    }

    @Test
    void shouldGetLineOfAPosition() {
        assertEquals(8, position.line());
    }

    @Test
    void shouldGetAColumnOfAPosition() {
        assertEquals(4, position.column());
    }
}