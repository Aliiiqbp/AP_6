package src.Model.Farm.Extra;

import src.Model.Entity;

public class Well extends Entity {
    private int wellCapacity = 10;

    private int amountOfWater = wellCapacity;

    public void setAmountOfWater(int amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public void setWellCapacity(int wellCapacity) {
        this.wellCapacity = wellCapacity;
    }

    public int getWellCapacity() {
        return wellCapacity;
    }

    public double wellChargeCost() {
        return 0;
    }

    public void wellCharge() {

    }
}