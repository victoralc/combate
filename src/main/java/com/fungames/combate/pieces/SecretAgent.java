package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class SecretAgent extends GamePiece {

    private SecretAgent() {}

    public static SecretAgent create() {
        return new SecretAgent();
    }

    @Override
    protected int power() {
        return type().power();
    }

    @Override
    protected Type type() {
        return Type.SECRET_AGENT;
    }
}
