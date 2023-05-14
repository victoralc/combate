package com.fungames.combate.board;

import com.fungames.combate.pieces.Piece;
import com.fungames.combate.pieces.direction.Direction;

import java.util.Optional;

public class Board {

    private final Grid grid;
    private Item selectedItem;

    private Board(Grid grid) {
        this.grid = grid;
    }

    public static Board create() {
        return new Board(Grid.of10x10());
    }

    public void initCells() {
        this.grid.initCells();
    }

    public void add(Item item) {
        this.grid.add(item);
    }

    public Grid getGrid() {
        return grid;
    }

    public int totalGridCells() {
        return this.grid.totalCells();
    }

    public Optional<Piece> getPieceAt(Position position) {
        return this.grid.getPieceAt(position);
    }

    public Cell getCellAt(Position position) {
        return this.grid.getCellAt(position);
    }

    public void moveSelectedItem(Direction newDirection) {
        grid.moveSelectedItem(newDirection);
    }

    public void setSelectedItem(Item item) {
        selectedItem = item;
        grid.setSelectedItem(item);
    }

    public Item getSelectedItem() {
        return selectedItem;
    }
}
