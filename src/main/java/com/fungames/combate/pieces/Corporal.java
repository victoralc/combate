package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Corporal extends Piece {

    private Corporal() {}

    public static Corporal create() {
        return new Corporal();
    }

    @Override
    public int power() {
        return type().power();
    }

    @Override
    public Type type() {
        return Type.CORPORAL;
    }
}
