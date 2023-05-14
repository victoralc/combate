package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.CellNotExistsException;
import com.fungames.combate.pieces.Bomb;
import com.fungames.combate.pieces.Piece;
import com.fungames.combate.pieces.Soldier;
import com.fungames.combate.pieces.direction.Direction;
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
        var cell = grid.getCellAt(Position.of(2, 5));

        assertNotNull(cell);
        assertEquals(100, grid.totalCells());
    }

    @Test
    void shouldAddAPieceInACell() {
        var position = Position.of(2, 5);
        addPieceAt(position);

        var cell = grid.getCellAt(position);

        assertNotNull(cell);
        assertFalse(cell.isEmpty());
        assertInstanceOf(Soldier.class, cell.getPiece());
    }

    @Test
    void shouldGetACellAtAGivenPosition() {
        var position2x5 = Position.of(2, 5);
        var cell = grid.getCellAt(position2x5);

        assertNotNull(cell);
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
        var position = Position.of(2, 5);
        addPieceAt(position);

        var optionalPiece = grid.getPieceAt(position);
        var piece = optionalPiece.get();

        assertNotNull(piece);
        assertInstanceOf(Soldier.class, piece);
    }

    @Test
    void shouldThrowCellNotExistsExceptionWhenGridIsNotInitialized() {
        Grid grid = Grid.of10x10();

        var position = Position.of(2, 5);
        addPieceAt(position);

        assertThrows(CellNotExistsException.class, () -> grid.getPieceAt(position));
    }

    @Test
    void shouldGetEmptyOptionalPieceWhenThereIsNoPieceAtAGivenPosition() {
        var position = Position.of(2, 5);
        var optionalPiece = grid.getPieceAt(position);

        assertTrue(optionalPiece.isEmpty());
        assertThrows(NoSuchElementException.class, optionalPiece::get);
    }

    private void addPieceAt(Position position) {
        grid.add(Item.createItem(Soldier.newSoldier(), position));
    }

    @Test
    void shouldMoveSelectedItemToANewPosition() {
        var soldier = Item.createItem(Soldier.newSoldier(), Position.of(2, 5));
        grid.setSelectedItem(soldier);
        grid.moveSelectedItem(Direction.UP);

        Cell cellAtPosition1x5 = grid.getCellAt(Position.of(1, 5));
        Piece pieceOfSelectedItem = grid.getSelectedItem().getPiece();

        assertEquals(Position.of(1, 5), grid.getSelectedItem().getCurrentPosition());
        assertTrue(cellAtPosition1x5.contains(pieceOfSelectedItem));
    }

    @Test
    void shouldRemoveAnItemAtAGivenPosition() {
        var position2x5 = Position.of(2, 5);
        var soldier = Item.createItem(Soldier.newSoldier(), position2x5);
        grid.add(soldier);

        grid.remove(soldier);

        var cell = grid.getCellAt(position2x5);
        var optionalPiece = grid.getPieceAt(position2x5);

        assertTrue(cell.isEmpty());
        assertTrue(optionalPiece.isEmpty());
    }

    @Test
    void shouldRemoveTheSelectedItemFromItsCell() {
        var position2x5 = Position.of(2, 5);
        var soldier = Item.createItem(Soldier.newSoldier(), position2x5);
        grid.add(soldier);
        grid.setSelectedItem(soldier);

        grid.removeSelectedItemFromItsCell();

        var cell = grid.getCellAt(position2x5);
        var optionalPiece = grid.getPieceAt(position2x5);

        assertTrue(cell.isEmpty());
        assertTrue(optionalPiece.isEmpty());
    }

    @Test
    void shouldNotRemoveAnItemFromACellIfTheCellDoesNotContainsIt() {
        var position2x5 = Position.of(2, 5);
        var item = Item.createItem(Soldier.newSoldier(), position2x5);
        grid.add(item);

        var bomb = Item.createItem(Bomb.newBomb(), position2x5);

        grid.remove(bomb);

        var cellOfTheSoldier = grid.getCellAt(position2x5);
        var soldierPiece = grid.getPieceAt(position2x5).get();

        assertFalse(cellOfTheSoldier.isEmpty());
        assertTrue(cellOfTheSoldier.contains(item.getPiece()));
        assertInstanceOf(Soldier.class, soldierPiece);
    }
}