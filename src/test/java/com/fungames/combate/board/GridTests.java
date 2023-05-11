package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GridTests {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = Grid.of10x10();
        grid.initCells();
    }

    @Test
    void shouldInitEachPositionOfTheGridWithCell() {
        var optionalCell = grid.getCellAt(Position.of(2, 5));

        assertNotNull(optionalCell.get());
        assertEquals(100, grid.totalCells());
    }

    @Test
    void shouldAddAPieceInACell() {
        var position = Position.of(2,5);
        addPieceAt(position);

        var cell = grid.getCellAt(position).get();

        assertNotNull(cell);
        assertFalse(cell.getPiece().isEmpty());
        assertInstanceOf(Soldier.class, cell.getPiece().get());
    }

    @Test
    void shouldGetACellAtAGivenPosition() {
        var position2x5 = Position.of(2, 5);
        var cell = grid.getCellAt(position2x5);

        assertNotNull(cell.get());
    }

    @Test
    void shouldGetCells() {
        assertNotNull(grid.getCells());
        assertEquals(10, grid.getCells().length);
    }

    @Test
    void shouldGet100InTotal() {
        assertEquals(100, grid.totalCells());
    }

    @Test
    void shouldGetNonNullPieceInAGivenPosition() {
        var position = Position.of(2,5);
        addPieceAt(position);

        var optionalPiece = grid.getPieceAt(position);
        var piece = optionalPiece.get();

        assertNotNull(piece);
        assertInstanceOf(Soldier.class, piece);
    }

    @Test
    void shouldReturnEmptyPieceWhenThereIsNoCellForThatGivenPosition() {
        Grid grid = Grid.of10x10();

        var position = Position.of(2,5);
        addPieceAt(position);

        var optionalPiece = grid.getPieceAt(position);

        assertTrue(optionalPiece.isEmpty());
        assertThrows(NoSuchElementException.class, optionalPiece::get);
    }

    @Test
    void shouldGetEmptyOptionalPieceWhenThereIsNoPieceAtAGivenPosition() {
        var position = Position.of(2,5);
        var optionalPiece = grid.getPieceAt(position);

        assertTrue(optionalPiece.isEmpty());
        assertThrows(NoSuchElementException.class, optionalPiece::get);
    }

    private void addPieceAt(Position position) {
        grid.add(Soldier.create(), position);
    }
}