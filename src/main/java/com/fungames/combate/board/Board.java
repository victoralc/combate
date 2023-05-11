package com.fungames.combate.board;

import com.fungames.combate.pieces.GamePiece;
import com.fungames.combate.pieces.direction.Direction;

import java.util.Optional;

public class Board {

    private final Grid grid;

    private Board(Grid grid) {
        this.grid = grid;
    }

    public static Board create() {
        return new Board(Grid.of10x10());
    }

    public void initCells() {
        this.grid.initCells();
    }

    public void add(GamePiece gamePiece, Position position) {
        this.grid.add(gamePiece, position);
    }

    public Grid getGrid() {
        return grid;
    }

    public int totalGridCells() {
        return this.grid.totalCells();
    }

    public Optional<GamePiece> getPieceAt(Position position) {
        return this.grid.getPieceAt(position);
    }

    public Optional<Cell> getCellAt(Position position) {
        return this.grid.getCellAt(position);
    }

    //TODO implement move action
    public void move(GamePiece gamePiece, Direction newDirection) {
        //...
    }
}
