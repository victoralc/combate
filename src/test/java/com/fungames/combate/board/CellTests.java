package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.Bomb;
import com.fungames.combate.pieces.SecretAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTests {
    private static final Position POSITION_2x5 = Position.of(2, 5);
    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = Cell.of(POSITION_2x5);
    }

    @Test
    void shouldCreateACellAtAGivenPosition() {
        assertNotNull(cell);
    }

    @Test
    void shouldCreateACellWithAGamePiece() {
        var secretAgent = SecretAgent.create();
        cell = Cell.with(secretAgent, POSITION_2x5);

        assertFalse(cell.getPiece().isEmpty());
        assertNotNull(cell.getPiece().get());
        assertInstanceOf(SecretAgent.class, cell.getPiece().get());
    }

    @Test
    void shouldAddAPieceIntoACellAtAGivenPosition() {
        var bomb = Bomb.create();
        cell.set(bomb);

        assertFalse(cell.getPiece().isEmpty());
        assertNotNull(cell.getPiece().get());
        assertInstanceOf(Bomb.class, cell.getPiece().get());
    }

    @Test
    void shouldRemovePieceOfACell() {
        cell.removePiece();

        assertTrue(cell.isEmpty());
        assertTrue(cell.getPiece().isEmpty());
    }

    @Test
    void shouldRemovePieceAlreadyNull() {
        cell.removePiece();
        cell.removePiece();

        assertTrue(cell.isEmpty());
        assertTrue(cell.getPiece().isEmpty());
    }

    @Test
    void shouldReturnTheLineOfTheCell() {
        assertEquals(2, cell.line());
    }

    @Test
    void shouldReturnTheColumnOfACell() {
        assertEquals(5, cell.column());
    }

    @Test
    void shouldGetAPieceOfTheCellForAGivenPosition() {
        var bomb = Bomb.create();
        cell = Cell.with(bomb, POSITION_2x5);

        assertFalse(cell.getPiece().isEmpty());
        assertNotNull(cell.getPiece().get());
        assertInstanceOf(Bomb.class, cell.getPiece().get());
    }

    @Test
    void shouldGetAPositionOfACell() {
        assertNotNull(cell.getPosition());
        assertEquals(2, cell.line());
        assertEquals(5, cell.column());
    }

    @Test
    void shouldThrowInvalidCellPositionExceptionWhenTryToInstantiateCellWithNullPosition(){
        assertThrows(InvalidCellPositionException.class, () -> Cell.of(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryToInstantiateCellWithNullGamePiece(){
        assertThrows(IllegalArgumentException.class, () -> Cell.with(null, null));
    }
}