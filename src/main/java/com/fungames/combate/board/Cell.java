package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.GamePiece;

import java.util.Optional;

class Cell {
    private final Position position;
    private GamePiece gamePiece;

    private Cell(Position position) {
        this.position = position;
    }

    private Cell(GamePiece gamePiece, Position position) {
        this.gamePiece = gamePiece;
        this.position = position;
    }

    public static Cell of(Position position) {
        if (position == null)
            throw new InvalidCellPositionException("Position of a cell cannot be null");
        return new Cell(position);
    }

    public static Cell with(GamePiece gamePiece, Position position) {
        if (gamePiece == null)
            throw new IllegalArgumentException("GamePiece of a cell cannot be null");
        return new Cell(gamePiece, position);
    }

    public void set(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    public void removePiece() {
        this.gamePiece = null;
    }

    public int line() {
        return this.position.line();
    }

    public int column(){
        return this.position.column();
    }

    public Optional<GamePiece> getPiece() {
        return Optional.ofNullable(gamePiece);
    }

    public Position getPosition() {
        return position;
    }

    public boolean isEmpty() {
        return gamePiece == null;
    }

    public boolean contains(GamePiece piece) {
        return !isEmpty() && this.gamePiece.equals(piece);
    }
}