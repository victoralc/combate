package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.Piece;

class Cell {
    private final Position position;
    private Piece piece;

    private Cell(Position position) {
        this.position = position;
    }

    private Cell(Piece piece, Position position) {
        this.piece = piece;
        this.position = position;
    }

    public static Cell of(Position position) {
        if (position == null)
            throw new InvalidCellPositionException("Position of a cell cannot be null");
        return new Cell(position);
    }

    public static Cell with(Piece piece, Position position) {
        if (piece == null)
            throw new IllegalArgumentException("Piece of a cell cannot be null");
        return new Cell(piece, position);
    }

    public void set(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public int line() {
        return this.position.line();
    }

    public int column() {
        return this.position.column();
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean contains(Piece piece) {
        return !isEmpty() && this.piece.equals(piece);
    }
}