package src.Model.Farm.Extra;

import src.Controller.Static;
import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Product.Water;

public class Well extends Entity {
    private double wellCapacity;
    private double amountOfWater;
    private double fillWellCost;
    private Movement movement;

    public Well(double x, double y) {
        wellCapacity = Static.WELL_CAPACITY_LVL_0;
        amountOfWater = wellCapacity;
        fillWellCost = Static.WELL_FILL_COST_LVL_0;
        this.movement = new Movement(0.0, x, y);
    }

    @Override
    public void upgradeLevel() {
        switch (level){
            case 0 : this.setFillWellCost( Static.WELL_FILL_COST_LVL_1 );
                     this.setWellCapacity( Static.WELL_CAPACITY_LVL_1);
                     break;
            case 1 : this.setFillWellCost( Static.WELL_FILL_COST_LVL_2 );
                     this.setWellCapacity( Static.WELL_CAPACITY_LVL_2);
                     break;
            case 2 : this.setFillWellCost( Static.WELL_FILL_COST_LVL_3 );
                     this.setWellCapacity( Static.WELL_CAPACITY_LVL_3);
                     break;
            case 3 : //it's not upgradable :)
                 break;
        }
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

    public void setFillWellCost(double fillWellCost) {
        this.fillWellCost = fillWellCost;
    }

    public void setWellCapacity(double wellCapacity) {
        this.wellCapacity = wellCapacity;
    }

    public double getFillWellCost() {
        return fillWellCost;
    }
}