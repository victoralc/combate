package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.CellNotExistsException;
import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.Piece;
import com.fungames.combate.pieces.direction.Direction;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

class Grid {
    private final Cell[][] cells;
    private Item selectedItem;

    private Grid(int line, int column) {
        this.cells = new Cell[line][column];
    }

    public static Grid of10x10() {
        return new Grid(10, 10);
    }

    public void initCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = Cell.of(Position.of(i, j));
            }
        }
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void add(Item item) {
        Cell cell = getCellAt(item.getCurrentPosition());
        if (cell.isEmpty()) {
            cell.set(item.getPiece());
        }
    }

    public Cell getCellAt(Position position) {
        try {
            Cell cell = cells[position.line()][position.column()];
            if (cell == null) {
                throw new CellNotExistsException(
                        String.format("Cell does not exists at position %s. It might not have been initialized.", position));
            }
            return cell;
        } catch (ArrayIndexOutOfBoundsException ex) {
          throw new InvalidCellPositionException("Invalid position for the cell.");
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int totalCells() {
        return Arrays.stream(cells)
                .mapToInt(cell -> (int) (Stream.of(cell).count()))
                .sum();
    }

    public Optional<Piece> getPieceAt(Position position) {
        var cell = getCellAt(position);
        return Optional.ofNullable(cell.getPiece());
    }

    public void remove(Item item) {
        Cell cell = getCellAt(item.getCurrentPosition());
        if (cell.contains(item.getPiece())) {
            cell.removePiece();
        }
    }

    public void moveSelectedItem(Direction direction) {
        removeSelectedItemFromItsCell();
        selectedItem.move(direction);
        setSelectedItemToTheNewCell();
    }

    public void removeSelectedItemFromItsCell() {
        Cell cell = getCellAt(selectedItem.getCurrentPosition());
        if (cell.contains(selectedItem.getPiece())) {
            cell.removePiece();
        }
    }

    private void setSelectedItemToTheNewCell() {
        Cell cell = getCellAt(selectedItem.getCurrentPosition());
        cell.set(selectedItem.getPiece());
    }

    public Item getSelectedItem() {
        return selectedItem;
    }
}