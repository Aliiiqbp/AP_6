package src.Model.Farm.Map;

import src.Model.Salable;

import java.util.ArrayList;

public class MarginCell {
    private int x;
    private ArrayList<Salable> salables;

    public MarginCell(int x) {
        this.x = x;
        salables = new ArrayList<>();
    }

    public ArrayList getSalables() {
        return salables;
    }

    public void clear() {
        salables.clear();
    }
}
