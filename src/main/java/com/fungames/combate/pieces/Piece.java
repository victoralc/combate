package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public abstract class Piece {

    public abstract int power();

    public abstract Type type();

    public boolean isMovable() {
        return type() != Type.BOMB && type() != Type.PRISIONER;
    }

}
