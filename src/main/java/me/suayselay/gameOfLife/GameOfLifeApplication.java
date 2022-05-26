package me.suayselay.gameOfLife;

import static me.suayselay.gameOfLife.Cell.CellState.ALIVE;
import static me.suayselay.gameOfLife.Cell.CellState.DEAD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameOfLifeApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		Cell.CellState X = ALIVE;
		Cell.CellState O = DEAD;

		// So we just successfully tested almost all cases now it is time to visually
		// look how our program works

		StringBuilder output = new StringBuilder();
		Cell.CellState[][] input = new Cell.CellState[][] {
				{ O, O, O, O, O, O, O, O },
				{ O, O, O, O, X, O, O, O },
				{ O, O, O, X, X, O, O, O },
				{ O, O, O, O, O, O, O, O }
		};
		Grid grid = new Grid(input);
		output
				.append("---------------------")
				.append("GENERATION[0]")
				.append("---------------------")
				.append("\n")
				.append(grid);

		grid = grid.getNextGeneration();
		output
				.append("---------------------")
				.append("GENERATION[1]")
				.append("---------------------")
				.append("\n")
				.append(grid);

		System.out.println("Generation for input is completed!");

		Files.write(Paths.get("output.txt"), output.toString().getBytes());

	}

}
