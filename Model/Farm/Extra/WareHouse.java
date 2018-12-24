package Model.Farm.Extra;

import Model.NTT;

public class WareHouse extends NTT {
    private int capacity = 10;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
