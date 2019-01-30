package Model.Farm.Extra;

import Controller.Static;
import src.Model.Coordinate.Movement;
import Model.Entity;
import Model.Product.Water;

public class Well extends Entity {
    private int wellCapacity;
    private int amountOfWater;
    private double fillWellCost;
    private Movement movement;

    public Well() {
        wellCapacity = Static.WELL_CAPACITY_LVL_0;
        amountOfWater = 0;
        fillWellCost = Static.WELL_FILL_COST_LVL_0;
        movement = new Movement();
    }

    @Override
    public void upgradeLevel() {
        switch (getLevel()) {
            case 0:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_1);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_1);
                break;
            case 1:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_2);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_2);
                break;
            case 2:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_3);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_3);
                break;
            case 3: //it's not upgradable :)
                break;
        }
        increaseLevel();
    }

    public double getAmountOfWater() {
        return amountOfWater;
    }

    public double getWellCapacity() {
        return wellCapacity;
    }

    public double wellChargeCost() {
        return fillWellCost;
    }

    public void chargeWell() {
        // TODO: 12/31/2018 remove money for charge = (wellCapacity - amountOfWater)/wellCapacity * chargeCost
        // if money ok
        this.amountOfWater = this.wellCapacity;
    }

    public Water buyWater() {
        if (amountOfWater > 0 ) {
            amountOfWater -= 1;
            return new Water(this.movement.getCurrentX(), this.movement.getCurrentY());
        }
        return null;
    }

    private void setFillWellCost(double fillWellCost) {
        this.fillWellCost = fillWellCost;
    }

    private void setWellCapacity(int wellCapacity) {
        this.wellCapacity = wellCapacity;
    }

    public double getFillWellCost() {
        return fillWellCost;
    }
}