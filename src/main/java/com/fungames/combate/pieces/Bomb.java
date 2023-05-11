package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Bomb extends GamePiece {

    private Bomb() {}

    public static Bomb create() {
        return new Bomb();
    }

    @Override
    protected int power() {
        return type().power();
    }

    @Override
    protected Type type() {
        return Type.BOMB;
    }
}
