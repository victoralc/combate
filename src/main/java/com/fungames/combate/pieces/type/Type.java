package com.fungames.combate.pieces.type;

public enum Type {
    PRISIONER(0),
    BOMB(0),
    SECRET_AGENT(1),
    SOLDIER(2),
    CORPORAL(3),
    SERGEANT(4),
    SUB_LIEUTENANT(5),
    LIEUTENANT(6),
    CAPTAIN(7),
    MAJOR(8),
    COLONEL(9),
    GENERAL(10);

    private final int power;

    Type(int power) {
        this.power = power;
    }

    public int power() {
        return power;
    }
}
