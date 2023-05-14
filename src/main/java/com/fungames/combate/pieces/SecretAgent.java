package com.fungames.combate.pieces;

import com.fungames.combate.pieces.type.Type;

public class SecretAgent extends Piece {

    private SecretAgent() {}

    public static SecretAgent create() {
        return new SecretAgent();
    }

    @Override
    public int power() {
        return type().power();
    }

    @Override
    public Type type() {
        return Type.SECRET_AGENT;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof SecretAgent other) {
            return other.power() == this.power() &&
                    other.type().equals(this.type());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
