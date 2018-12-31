package src.Model;

public abstract class Salable extends Entity {
    protected double sellPrice, buyPrice;
    protected double volume;

    public Salable(double sellPrice, double buyPrice, double volume) {
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.volume = volume;
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
