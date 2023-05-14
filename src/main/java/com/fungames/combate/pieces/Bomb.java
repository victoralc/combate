package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Bomb extends Piece {

    private Bomb() {}

    public static Bomb newBomb() {
        return new Bomb();
    }

    @Override
    public int power() {
        return type().power();
    }

    @Override
    public Type type() {
        return Type.BOMB;
    }
}
