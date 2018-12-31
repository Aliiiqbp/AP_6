package src.Model.Farm.Extra;

import src.Controller.Static;
import src.Model.Capacity;
import src.Model.Entity;
import src.Model.Salable;

public class WareHouse extends Entity {
    private Capacity capacity;

    public WareHouse() {
        this.capacity = new Capacity(Static.WAREHOUSE_CAPACITY_LVL_0);
    }

    public void add(Salable salable, int count) {
        this.capacity.add(salable, count);
    }

    public void get(Salable salable, int count) {
        this.capacity.get(salable, count);
    }

    public int getNumberOfSalable(Salable salable) {
        return this.capacity.getNumberOfSalable(salable);
    }
}
