package src.Model;

import src.Model.Coordinate.Movement;

public abstract class Salable extends Entity {
    protected double sellPrice, buyPrice;
    protected double volume;
    protected Movement movement;

    public Salable(double sellPrice, double buyPrice, double volume) {
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.volume = volume;
    }

    public Movement getMovement() {
        return movement;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getVolume() {
        return volume;
    }
}
