package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.GamePiece;
import com.fungames.combate.pieces.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardTests {
    Board board;

    @BeforeEach
    void setUp() {
        board = Board.create();
        board.initCells();
    }

    @Test
    void shouldCreateBoardWithGrid() {
        assertNotNull(board);
        assertNotNull(board.getGrid());
    }

    @Test
    void shouldCreateBoardWith100EmptyCells() {
        Board board = Board.create();

        int totalCells = board.totalGridCells();
        assertEquals(100, totalCells);

        var cellOptional = board.getCellAt(Position.of(2, 5));
        assertTrue(cellOptional.isEmpty());
    }

    @Test
    void shouldInitTheGridWithCells() {
        var cellOptional = board.getCellAt(Position.of(2, 5));
        assertNotNull(cellOptional.get());
    }

    @Test
    void shouldRetrieveCellWithNonEmptyPosition() {
        var optionalCell = board.getCellAt(Position.of(2, 5));

        assertNotNull(optionalCell.get().getPosition());
        assertEquals(2, optionalCell.get().line());
        assertEquals(5, optionalCell.get().column());
    }

    @Test
    void shouldAddAGamePieceToABoardGridProperly() {
        var pos5x7 = Position.of(5, 7);
        board.add(Soldier.create(), pos5x7);

        Optional<GamePiece> piece = board.getPieceAt(pos5x7);

        var pieceInCell = piece.get();
        assertNotNull(pieceInCell);
        assertInstanceOf(Soldier.class, pieceInCell);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenGetEmptyOptionalPiece() {
        var position = Position.of(5, 7);
        Optional<GamePiece> piece = board.getPieceAt(position);

        assertThrows(NoSuchElementException.class, piece::get);
    }

    //TODO implement move() method
    @Test
    void shouldMoveAPieceAtAGivenPosition() {

    }
}