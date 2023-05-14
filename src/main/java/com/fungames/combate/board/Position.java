package com.fungames.combate.board;

public record Position(int line, int column){

    private static final int MIN_BORDER_LIMIT = 0;
    private static final int MAX_BORDER_LIMIT = 9;

    public Position {
        if (line < MIN_BORDER_LIMIT || column < MIN_BORDER_LIMIT)
            throw new IllegalArgumentException("Invalid line or column. It cannot be less than " + MIN_BORDER_LIMIT);
        if (line > MAX_BORDER_LIMIT || column > MAX_BORDER_LIMIT)
            throw new IllegalArgumentException("Invalid line or column. It cannot be greater than " +MAX_BORDER_LIMIT);
    }

    public static Position of(int line, int column) {
        return new Position(line, column);
    }

    public boolean isMaxUpLimit() {
        return line == 0;
    }

    public boolean isMinDownLimit(){
        return line == 9;
    }

    public boolean isMaxLeftLimit(){
        return column == 0;
    }

    public boolean isMaxRightLimit(){
        return column == 9;
    }
}