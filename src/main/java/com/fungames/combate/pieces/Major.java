package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class Major extends GamePiece {
    @Override
    protected int power() {
        return type().power();
    }

    @Override
    protected Type type() {
        return Type.MAJOR;
    }
}
