package src.Model.Farm.Map;

import src.Model.Entity;
import src.Model.Salable;

import java.util.ArrayList;
import java.util.HashMap;

public class Map extends Entity {

    private Cell[][] cells;
    private ArrayList<Entity> objects;
    private HashMap<Entity, Cell> cellMap;
    private int width, height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i, j, this);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void addObject(Entity entity, Cell cell) {
        if (!objects.contains(entity)) { //it is not necessary but it is better in this way
            objects.add(entity);
            if (!cellMap.containsKey(entity)) {
                cellMap.put(entity, cell);
            }
        }
    }

    public void addSalable(Salable salable) {
        if (!objects.contains(salable)) { //it is not necessary but it is better in this way
            objects.add(salable);
            Cell cell = getMappedCell(salable.getMovement().getCurrentX(), salable.getMovement().getCurrentY());
            if (!cellMap.containsKey(salable)) {
                cellMap.put(salable, cell);
            }
        }
    }

    public void removeObject(Entity entity, Cell cell) {
        if (objects.contains(entity)) {
            objects.remove(entity);
            if (cellMap.containsKey(entity)) {
                cellMap.remove(entity, cell);
            }
        }
    }

    public boolean containObject(Entity entity) {
        if (objects.contains(entity)) {
            return true;
        }
        return false;
    }

    public Cell getCellThatContainsObject(Entity entity) {
        return cellMap.get(entity);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getMappedCell(double x, double y) {
        if (0 <= x && x < this.width && 0 <= y && y < this.height) {
            return this.getCell((int) Math.floor(x), (int) Math.floor(y));
        }
        return null;
    }
}