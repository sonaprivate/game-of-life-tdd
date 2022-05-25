package me.suayselay.gameOfLife;

import lombok.*;

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
    
}
