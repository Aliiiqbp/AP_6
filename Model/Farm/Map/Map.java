package Model.Farm.Map;

public class Map {

    private Cell[][] cells;

    public Map(Cell[][] cells, int n) {
        cells = new Cell[n][n];
    }

    public Cell[][] getCells() {
        return cells;
    }
}
