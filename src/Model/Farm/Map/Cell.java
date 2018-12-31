package src.Model.Farm.Map;

import src.Model.Entity;

import java.util.ArrayList;

public class Cell {

    private int x, y;
    private ArrayList<Entity> objects;
    private Map map;

    public Cell(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
        objects = new ArrayList<>();
    }

    public void removeFromCell(Entity object) {
        if (objects.contains(object)) {
            objects.remove(object);
            this.map.removeObject(object, this);
        }
    }

    public void addToCell(Entity object) {
        if (!objects.contains(object)) {
            objects.add(object);
            this.map.addObject(object, this);
        }
    }

    public boolean containObject(Entity object) {
        if (objects.contains(object)) {
            return true;
        }
        return false;
    }

    public Map getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}