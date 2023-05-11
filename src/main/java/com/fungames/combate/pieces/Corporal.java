package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Corporal extends GamePiece {

    private Corporal() {}

    public static Corporal create() {
        return new Corporal();
    }

    @Override
    protected int power() {
        return type().power();
    }

    @Override
    protected Type type() {
        return Type.CORPORAL;
    }
}
