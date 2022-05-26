package me.suayselay.gameOfLife;

import static me.suayselay.gameOfLife.Cell.CellState.ALIVE;
import static me.suayselay.gameOfLife.Cell.CellState.DEAD;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {

    public static final Cell.CellState X = ALIVE;
    public static final Cell.CellState O = DEAD;

    // check for if input correctly pass to grid
    @Test
    public void shouldBeInitiatedWithInitialState() {
        Cell.CellState[][] input = new Cell.CellState[][] {
                { O, O, O, O, O, O, O, O },
                { O, O, O, O, X, O, O, O },
                { O, O, O, X, X, O, O, O },
                { O, O, O, O, O, O, O, O }
        };
        Grid grid = new Grid(input);
        Cell.CellState[][] state = grid.getCellsState();
        Assert.assertArrayEquals(input, state);
    }

    // check if getAliveCount works correctly or not
    @Test
    public void shouldBeAbleToDeterminaNumberOfAliveCells() {
        Cell.CellState[][] input = new Cell.CellState[][] {
                { O, O, O, O, O, O, O, O },
                { O, O, O, O, X, O, O, O },
                { O, O, O, X, X, O, O, O },
                { O, O, O, O, O, O, O, O }
        };
        Grid grid = new Grid(input);
        int expectedNumberOfAliveCells = 3;
        int actualAliveCells = grid.getAliveCount();
        assertEquals(expectedNumberOfAliveCells, actualAliveCells);
    }

}
