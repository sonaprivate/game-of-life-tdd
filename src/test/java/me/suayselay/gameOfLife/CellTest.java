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

    // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    @Test
    public void shouldBeDeadByUnderPopulationWhenLiveCellHasLessThanTwoAliveNeighbors() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 1;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(DEAD, cell.getCellState());
    }

    // Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void shouldBeAliveWhenLiveCellHasGreaterThanTwoAliveNeighbors() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 2;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(ALIVE, cell.getCellState());
    }

    // Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void shouldBeAliveWhenLiveCellHasExactlyTwoOrThreeAliveNeighbors() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 3;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(ALIVE, cell.getCellState());
    }

    // Any live cell with more than three live neighbours dies, as if by overpopulation.
    @Test
    public void shouldBeDeadByOverPopulationWhenLiveCellHasMoreThanThreeAliveNeighbors() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 4;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(DEAD, cell.getCellState());
    }

    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void shouldBeAliveByReproductionWhenDeadCellHasThreeAliveNeighbors() {
        Cell cell = new Cell(DEAD);
        int numberOfAliveNeigbours = 3;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(ALIVE, cell.getCellState());
 
    }

    //Any Dead cell with more than three live neighbours dies, as if by overpopulation.
    @Test
    public void shouldBeStillDeadWhenDeadCellHasMoreThanThreeAliveNeighbors() {
        Cell cell = new Cell(DEAD);
        int numberOfAliveNeigbours = 4;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(DEAD, cell.getCellState());
    }

    //Any dead cell with exactly two live neighbours becomes a dead cell
    @Test
    public void shouldBeStillDeadWhenDeadCellHasLessThanThreeAliveNeighbors() {
        Cell cell = new Cell(DEAD);
        int numberOfAliveNeigbours = 2;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        Assert.assertEquals(DEAD, cell.getCellState());
    }

}
