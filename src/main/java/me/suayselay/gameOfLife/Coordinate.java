package me.suayselay.gameOfLife;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@AllArgsConstructor
public class Coordinate {

    private final int row;
    private final int col;

    // Get neighbors of specigic Cell {it should return list of coordinates}
    public List<Coordinate> getNeighbours(Grid grid) {
        List<Coordinate> neighbours = new ArrayList<>();
        Cell[][] cells = grid.getCells();
        int lastRowIndex = cells.length - 1;
        int lastColumnIndex = cells[0].length - 1;
        int row = this.getRow();
        int col = this.getCol();
        for (int xOffset = -1; xOffset < 2; xOffset++) {
            for (int yOffset = -1; yOffset < 2; yOffset++) {
                addNeigbours(neighbours, lastRowIndex, lastColumnIndex, row, col, xOffset, yOffset);
            }
        }
 
        return neighbours;
 
    }

    // Add Neighbors to Cell
    private void addNeigbours(List<Coordinate> neighbours, int lastRowIndex, int lastColumnIndex, int row, int col, int xOffset, int yOffset) {
        int newRow = row + yOffset;
        int newCol = col + xOffset;
        if (isNotTheSameCell(xOffset, yOffset) && isNotOutOfMatrix(lastRowIndex, lastColumnIndex, newRow, newCol)) {
            neighbours.add(new Coordinate(newRow, newCol));
        }
    }
    
    // Check if matrix out of bounds
    private boolean isNotOutOfMatrix(int lastRowIndex, int lastColumnIndex, int newRow, int newCol) {
        return (newRow > -1 && newCol > -1) && (newRow <= lastRowIndex && newCol <= lastColumnIndex);
    }

    // is entered cell coordinate is different than the original cell
    private boolean isNotTheSameCell(int xOffset, int yOffset) {
        return xOffset != 0 || yOffset != 0;
    }

    // overriding other useful methods
    @Override
    public int hashCode() {
        int result;
        result = row / 11;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
 
        Coordinate that = (Coordinate) obj;
 
        return row == that.row && col == that.col;
    }
}
