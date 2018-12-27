package src.Model.Farm.Extra;

import src.Model.Entity;

public class WareHouse extends Entity {
    private int capacity = 10;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
