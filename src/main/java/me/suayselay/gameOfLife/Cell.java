package me.suayselay.gameOfLife;

import lombok.*;

import static me.suayselay.gameOfLife.Cell.CellState.ALIVE;
import static me.suayselay.gameOfLife.Cell.CellState.DEAD;

@Getter
@Setter
@AllArgsConstructor
public class Cell {

    private CellState cellState;

    // Declaring cell state
    public enum CellState {
        ALIVE,
        DEAD
    }

    // adding several methods based on rules: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

    public void getCellNextStateHavingAliveNeighbours(int numberOfAliveNeigbours) {
        cellState = canLive(numberOfAliveNeigbours) ? ALIVE : DEAD;
    }
 
    private boolean canLive(int numberOfAliveNeigbours) {
        return isReproductionPossible(numberOfAliveNeigbours) || (!isCellHasOverPopulatedORUnderPopulatedNeighbourHood(numberOfAliveNeigbours) && cellState == ALIVE);
    }
 
    private boolean isReproductionPossible(int numberOfAliveNeigbours) {
        return cellState == DEAD && numberOfAliveNeigbours == 3;
    }
 
    private boolean isCellHasOverPopulatedORUnderPopulatedNeighbourHood(int numberOfAliveNeigbours) {
        return numberOfAliveNeigbours != 2 && numberOfAliveNeigbours != 3;
    }
    
}
