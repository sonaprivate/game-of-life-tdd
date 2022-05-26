package me.suayselay.gameOfLife;

public class Grid {
    private Cell[][] cells;

    // initialising constructor with the whole cells in the grid
    public Grid(Cell.CellState[][] input) {
        cells = new Cell[input.length][];
        for (int row = 0; row < input.length; row++) {
            cells[row] = new Cell[input[row].length];
            for (int col = 0; col < input[row].length; col++) {
                cells[row][col] = new Cell(input[row][col]);
            }
        }
    }
}
