package src.Model.Farm.Map;

import src.Model.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Map extends Entity {

    private Cell[][] cells;
    private ArrayList<Entity> objects;
    private HashMap<Entity, Cell> cellMap;

    public Map(int n) {
        cells = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell(i, j, this);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void addObject(Entity entity, Cell cell) {
        if (!objects.contains(entity)) {
            objects.add(entity);
            cellMap.put(entity, cell);
        }
    }

    public void removeObject(Entity entity, Cell cell) {
        if (objects.contains(entity)) {
            objects.remove(entity);
            cellMap.remove(entity, cell);
        }
    }

    public boolean containObject(Entity entity) {
        if (objects.contains(entity)) {
            return true;
        }
        return false;
    }

    public Cell getCellThatContain(Entity entity) {
        return cellMap.get(entity);
    }
}