package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Prisoner extends Piece {

    public static Prisoner create() {
        return new Prisoner();
    }

    @Override
    public int power() {
        return type().power();
    }

    @Override
    public Type type() {
        return Type.PRISIONER;
    }
}
