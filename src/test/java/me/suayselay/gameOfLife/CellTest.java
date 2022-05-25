package me.suayselay.gameOfLife;

import org.junit.Assert;
import org.junit.Test;

import static me.suayselay.gameOfLife.Cell.CellState.ALIVE;
import static me.suayselay.gameOfLife.Cell.CellState.DEAD;

public class CellTest {
    
    @Test
    public void shouldHaveStateLiveWhenAlive() {
        Cell cell = new Cell(ALIVE);
        Assert.assertEquals(ALIVE, cell.getCellState());
    }

    @Test
    public void shouldHaveStateDeadWhenDead() {
        Cell cell = new Cell(DEAD);
        Assert.assertEquals(DEAD, cell.getCellState());
    }

    // Any live cell with two live neighbours dies, as if by underpopulation
    @Test
    public void shouldBeAliveWhenLiveCellHasGreaterThanTwoAliveNeighbors() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 1;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(ALIVE, cell.getCellState());
    }

}
