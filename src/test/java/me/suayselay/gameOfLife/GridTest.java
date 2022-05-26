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

    // this testing method checks if method works correctly when counting alive
    // neighbors for a specific cell
    @Test
    public void shouldBeAbleToCountNumberOfAliveNeighborsForACell() {
        Cell.CellState[][] input = new Cell.CellState[][] {
                { O, O, O, O, O, O, O, O },
                { O, O, X, O, X, O, O, O },
                { O, O, X, X, X, O, O, O },
                { O, O, O, O, O, O, O, O }
        };

        Grid grid = new Grid(input);
        // neighbours for (1,3)
        List<Coordinate> neighbours = new ArrayList<>();
        neighbours.add(new Coordinate(0, 2));
        neighbours.add(new Coordinate(0, 3));
        neighbours.add(new Coordinate(0, 4));
        neighbours.add(new Coordinate(1, 2));
        neighbours.add(new Coordinate(1, 4));
        neighbours.add(new Coordinate(2, 2));
        neighbours.add(new Coordinate(2, 3));
        neighbours.add(new Coordinate(2, 4));

        int expectedNumberOfAliveNeigbours = 5;

        int aliveCountOf = grid.getAliveCountOf(neighbours);
        Assert.assertEquals(expectedNumberOfAliveNeigbours, aliveCountOf);
    }

    // Writing test method for checking if it get correctly the next generation
    @Test
    public void shouldBeAbleToGetNextGeneration() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };

        Grid grid = new Grid(input);
 
        Cell.CellState[][] expectedGeneration = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
 
        Grid nextGeneration = grid.getNextGeneration();
        assertArrayEquals(expectedGeneration, nextGeneration.getCellsState());
    }

}
