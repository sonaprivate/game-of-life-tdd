package me.suayselay.gameOfLife;

import static me.suayselay.gameOfLife.Cell.CellState.ALIVE;
import static me.suayselay.gameOfLife.Cell.CellState.DEAD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoordinateTest {

    private static final Cell.CellState X = ALIVE;
    private static final Cell.CellState O = DEAD;

    // Check if the cell gets cells correctly or not
    @Test
    public void shouldBeAbleToGetNeighborsForACell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };

        Grid grid = new Grid(input);
        List<Coordinate> expectedNeigbours = new ArrayList<>();
        expectedNeigbours.add(new Coordinate(0, 2));
        expectedNeigbours.add(new Coordinate(0, 3));
        expectedNeigbours.add(new Coordinate(0, 4));
        expectedNeigbours.add(new Coordinate(1, 2));
        expectedNeigbours.add(new Coordinate(1, 4));
        expectedNeigbours.add(new Coordinate(2, 2));
        expectedNeigbours.add(new Coordinate(2, 3));
        expectedNeigbours.add(new Coordinate(2, 4));
        List<Coordinate> actualNeighbours = new Coordinate(1, 3).getNeighbours(grid);
        assertEquals(expectedNeigbours.size(), actualNeighbours.size());
        assertTrue(expectedNeigbours.contains(new Coordinate(0, 2)));
        assertTrue(expectedNeigbours.contains(new Coordinate(0, 3)));
        assertTrue(expectedNeigbours.contains(new Coordinate(0, 4)));
        assertTrue(expectedNeigbours.contains(new Coordinate(1, 2)));
        assertTrue(expectedNeigbours.contains(new Coordinate(2, 2)));
        assertTrue(expectedNeigbours.contains(new Coordinate(2, 3)));
        assertTrue(expectedNeigbours.contains(new Coordinate(2, 4)));
    }
    
}
