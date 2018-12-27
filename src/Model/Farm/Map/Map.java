package src.Model.Farm.Map;

import src.Model.Entity;

public class Map extends Entity {

    private Cell[][] cells;

    public Map(int n) {
        cells = new Cell[n][n];
    }

    public Cell[][] getCells() {
        return cells;
    }
}