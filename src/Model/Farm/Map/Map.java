package Model.Farm.Map;

import Model.Entity;
import Model.Salable;

import java.util.ArrayList;
import java.util.HashMap;

public class Map extends Entity {

    private Cell[][] cells;
    private ArrayList<Salable> salables;
    private HashMap<Salable, Cell> cellMap;
    private int width, height;

    public ArrayList<Salable> getSalables() {     return salables;    }

    public Map(int width, int height) {
        this.salables = new ArrayList<Salable>();
        this.cellMap = new HashMap<>();
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i, j, this);
            }
        }
    } //ok

    private Cell getCell(int x, int y) {
        return cells[x][y];
    } //ok

    public Cell getMappedCell(double x, double y) {
        // Consider that game is in a 800 * 600 screen
        // and our map is  10 * 10
        x = x / 80 ;
        y = y / 60 ;
        if (0 <= x && x < this.width && 0 <= y && y < this.height) {
            return this.getCell((int) Math.floor(x), (int) Math.floor(y));
        }
        return null;
    }

    public void addEntity(Salable salable, Cell cell) {
        if (!salables.contains(salable)) { //it is not necessary but it is better in this way
            salables.add(salable);
        }
        if (!cellMap.containsKey(salable)) {
            cellMap.put(salable, cell);
        }
        if (!cell.containSalable(salable)) {
            cell.addToCell(salable);
        }
    } //ok

    public void addSalable(Salable salable) {
        if (!salables.contains(salable)) { //it is not necessary but it is better in this way
            salables.add(salable);
        }
        Cell cell = getMappedCell(salable.getMovement().getCurrentX(), salable.getMovement().getCurrentY());
        if (!cellMap.containsKey(salable)) {
            cellMap.put(salable, cell);
        }
        if (!cell.containSalable(salable)) {
            cell.addToCell(salable);
        }
    } //ok

    public void removeObject(Salable salable, Cell cell) {
        if (salables.contains(salable)) {
            salables.remove(salable);
        }
        if (cellMap.containsKey(salable)) {
            cellMap.remove(salable, cell);
        }
        if (cell.containSalable(salable)) {
            cell.removeFromCell(salable);
        }
    } //ok

    public void removeSalable(Salable salable) {
        if (salables.contains(salable)) {
            salables.remove(salable);
        }
        Cell cell = getMappedCell(salable.getMovement().getCurrentX(), salable.getMovement().getCurrentY());
        if (cellMap.containsKey(salable)) {
            cellMap.remove(salable, cell);
        }
        if (cell.containSalable(salable)) {
            cell.removeFromCell(salable);
        }
    } //ok

    public boolean containSalable(Salable salable) {
        if (salables.contains(salable)) {
            return true;
        }
        return false;
    } //ok

    public Cell getCellThatContainsObject(Salable salable) {
        return cellMap.get(salable);
    } //ok

    public int getWidth() {
        return width;
    } //ok

    public int getHeight() {
        return height;
    } //ok

    public void run() {
        for (Salable salable: salables) {
            salable.getMovement().move();
            // TODO: 1/25/2019 salables works
        }
    }
}