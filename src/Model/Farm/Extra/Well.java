package src.Model.Farm.Extra;

import src.Controller.Static;
import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Product.Water;

public class Well extends Entity {
    private double wellCapacity;
    private double amountOfWater;
    private Movement movement;

    public Well(double x, double y) {
        wellCapacity = Static.WELL_CAPACITY_LVL_0;
        amountOfWater = wellCapacity;
        this.movement = new Movement(0.0, x, y);
    }

    public double getAmountOfWater() {
        return amountOfWater;
    }

    public double getWellCapacity() {
        return wellCapacity;
    }

    public double wellChargeCost() {
        return 0;
    }

    public void wellCharge() {
        // TODO: 12/31/2018 get money for charge = (wellCapacity - amountOfWater)/wellCapacity * chargeCost
        // if money ok
        this.amountOfWater = this.wellCapacity;
    }

    public Water buyWater() {
        return new Water(Static.WELL_WATER_AMOUNT, this.movement.getCurrentX(), this.movement.getCurrentY());
    }
}