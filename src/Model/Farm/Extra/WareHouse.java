package Model.Farm.Extra;

import Controller.Static;
import Model.Capacity;
import Model.Entity;
import Model.Salable;

import java.util.ArrayList;

public class WareHouse extends Entity {
    private Capacity capacity;

    public WareHouse() {
        this.capacity = new Capacity(Static.WAREHOUSE_CAPACITY_LVL_0);
    }

    public void add(Salable salable, int count) {
        this.capacity.add(salable, count);
    }

    public void add(Salable salable) {
        this.capacity.add(salable);
    }

    public void add(ArrayList<Salable> salables) {
        this.capacity.add(salables);
    }

    public boolean canAdd(Salable salable) {
        return capacity.canAdd(salable);
    }

    public boolean canAdd(ArrayList<Salable> salables) {
        return capacity.canAdd(salables);
    }

    public void remove(Salable salable, int count) {
        this.capacity.remove(salable, count);
    }

    public void remove(Salable salable) {
        this.capacity.remove(salable);
    }

    public int getNumberOfSalable(Salable salable) {
        return this.capacity.getNumberOfSalable(salable);
    }

    @Override
    public void upgradeLevel() {
        switch (getLevel()) {
            case 0:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_1);
                break;
            case 1:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_2);
                break;
            case 2:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_3);
                break;
            case 3:
                break; // can't remove upgraded
        }
        increaseLevel();
    }
}
