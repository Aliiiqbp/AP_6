package src.Model.Farm.Map;

import src.Model.NTT;

public class Map extends NTT {

    private Cell[][] cells;

    public Map(Cell[][] cells, int n) {
        cells = new Cell[n][n];
    }

    public Cell[][] getCells() {
        return cells;
    }
}
