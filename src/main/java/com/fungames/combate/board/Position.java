package com.fungames.combate.board;

public record Position(int line, int column){
    public Position {
        if (line < 0 || column < 0)
            throw new IllegalArgumentException("Invalid line or column. It cannot be less than zero.");
        if (line > 10 || column > 10)
            throw new IllegalArgumentException("Invalid line or column. It cannot be greater than 10.");
    }

    public static Position of(int line, int column) {
        return new Position(line, column);
    }
}