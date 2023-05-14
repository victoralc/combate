package com.fungames.combate.board;

import com.fungames.combate.pieces.Piece;
import com.fungames.combate.pieces.direction.Direction;

public class Item {
    private Piece piece;
    private Position position;

    private Item(Piece piece, Position position) {
        this.piece = piece;
        this.position = position;
    }

    public static Item createItem(Piece piece, Position position) {
        return new Item(piece, position);
    }

    public void move(Direction direction) {
        if (piece.isMovable()) {
            switch (direction) {
                case UP -> {
                    if (!position.isMaxUpLimit()) {
                        position = Position.of(position.line() - 1, position.column());
                    }
                }
                case DOWN -> {
                    if (!position.isMinDownLimit()) {
                        position = Position.of(position.line() + 1, position.column());
                    }
                }
                case LEFT -> {
                    if (!position.isMaxLeftLimit()) {
                        position = Position.of(position.line(), position.column() - 1);
                    }
                }
                case RIGHT -> {
                    if (!position.isMaxRightLimit()) {
                        position = Position.of(position.line(), position.column() + 1);
                    }
                }
            }
        }
    }

    public Position getCurrentPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
