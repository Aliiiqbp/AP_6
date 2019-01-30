package src.Model.Farm.Map;

import src.Model.Salable;

import java.util.ArrayList;

public class Cell {

    private int x, y;
    private ArrayList<Salable> salables;
    private Map map;

    public Cell(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
        salables = new ArrayList<>();
    } //ok

    public void removeFromCell(Salable salable) {
        if (salables.contains(salable)) {
            salables.remove(salable);
            if (this.map.containSalable(salable)) {
                this.map.removeObject(salable, this);
            }
        }
    }

    public void addToCell(Salable salable) {
        if (!salables.contains(salable) && salable != null) {
            salables.add(salable);
            if (!this.map.containSalable(salable)) {
                this.map.addEntity(salable, this);
            }
        }
    }

    public boolean containSalable(Salable salable) {
        if (salables.contains(salable)) {
            return true;
        }
        return false;
    }

    public ArrayList getSalables() {
        return salables;
    }

    public void clear() {
        salables.clear();
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