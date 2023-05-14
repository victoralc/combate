package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Sargeant extends Piece {

    @Override
    public int power() {
        return type().power();
    }

    @Override
    public Type type() {
        return Type.CORPORAL;
    }
}
