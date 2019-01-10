package src.Model.Farm.Map;

import src.Model.Entity;

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

    public static Cell getMappedCell(double x, double y, Map map) {
        if (0 <= x && x < map.width && 0 <= y && y < map.height) {
            return map.getCell((int) Math.floor(x), (int) Math.floor(y));
        }
        return null;
    }
}