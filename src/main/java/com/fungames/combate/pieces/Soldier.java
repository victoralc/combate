package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Soldier extends GamePiece {

    private Soldier() {}

    public static Soldier create() {
        return new Soldier();
    }

    @Override
    public Type type() {
        return Type.SOLDIER;
    }

    @Override
    public int power() {
        return type().power();
    }

}
