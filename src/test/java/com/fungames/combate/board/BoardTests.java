package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.CellNotExistsException;
import com.fungames.combate.pieces.Piece;
import com.fungames.combate.pieces.Soldier;
import com.fungames.combate.pieces.direction.Direction;
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
        assertThrows(CellNotExistsException.class,
                () -> board.getCellAt(Position.of(2, 5)));
    }

    @Test
    void shouldInitTheGridWithCells() {
        var cell = board.getCellAt(Position.of(2, 5));
        assertNotNull(cell);
    }

    @Test
    void shouldRetrieveCellWithNonEmptyPosition() {
        var cell = board.getCellAt(Position.of(2, 5));

        assertNotNull(cell.getPosition());
        assertEquals(2, cell.line());
        assertEquals(5, cell.column());
    }

    @Test
    void shouldAddAGamePieceToABoardGridProperly() {
        var pos5x7 = Position.of(5, 7);
        board.add(Item.createItem(Soldier.newSoldier(), pos5x7));

        Optional<Piece> piece = board.getPieceAt(pos5x7);

        var pieceInCell = piece.get();
        assertNotNull(pieceInCell);
        assertInstanceOf(Soldier.class, pieceInCell);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenGetEmptyOptionalPiece() {
        var position = Position.of(5, 7);
        Optional<Piece> piece = board.getPieceAt(position);

        assertThrows(NoSuchElementException.class, piece::get);
    }

    @Test
    void shouldMoveSelectedItemToANewPosition() {
        var soldier = Item.createItem(Soldier.newSoldier(), Position.of(2, 5));
        board.setSelectedItem(soldier);
        board.moveSelectedItem(Direction.UP);

        Cell cellAtPosition1x5 = board.getCellAt(Position.of(1, 5));
        Piece pieceOfSelectedItem = board.getSelectedItem().getPiece();

        assertEquals(Position.of(1, 5), board.getSelectedItem().getCurrentPosition());
        assertTrue(cellAtPosition1x5.contains(pieceOfSelectedItem));
    }
}