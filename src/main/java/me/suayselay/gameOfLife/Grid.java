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

    // Get Cell state
    public Cell.CellState[][] getCellsState() {
        Cell.CellState[][] cellStates = new Cell.CellState[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            cellStates[row] = new Cell.CellState[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                cellStates[row][col] = cells[row][col].getCellState();
            }
        }
        return cellStates;
    }
}
