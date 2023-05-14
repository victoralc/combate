package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Soldier extends Piece {

    private Soldier() {}

    public static Soldier newSoldier() {
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
