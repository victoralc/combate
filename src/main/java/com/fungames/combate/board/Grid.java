package com.fungames.combate.board;

import com.fungames.combate.core.exceptions.InvalidCellPositionException;
import com.fungames.combate.pieces.GamePiece;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

class Grid {
    private final Cell[][] cells;

    private Grid(int line, int column) {
        this.cells = new Cell[line][column];
    }

    public static Grid of10x10() {
        return new Grid(10, 10);
    }

    public void initCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = Cell.of(Position.of(i, j));
            }
        }
    }

    public void add(GamePiece gamePiece, Position position) {
        Optional<Cell> optCell = getCellAt(position);
        optCell.ifPresent(cell -> cell.set(gamePiece));
    }

    public Optional<Cell> getCellAt(Position position) {
        try {
            Cell cell = cells[position.line()][position.column()];
            return Optional.ofNullable(cell);
        } catch (ArrayIndexOutOfBoundsException ex) {
          throw new InvalidCellPositionException("Invalid position for the cell.");
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int totalCells() {
        return Arrays.stream(cells)
                .mapToInt(cell -> (int) (Stream.of(cell).count()))
                .sum();
    }

    public Optional<GamePiece> getPieceAt(Position position) {
        var optionalCell = getCellAt(position);
        if (optionalCell.isPresent()) {
            return optionalCell.get().getPiece();
        }
        return Optional.empty();
    }

    public void remove(GamePiece gamePiece, Position position) {
        getCellAt(position)
            .ifPresent(cell -> {
                if (cell.contains(gamePiece)) {
                    cell.removePiece();
                }
            }
        );
    }
}