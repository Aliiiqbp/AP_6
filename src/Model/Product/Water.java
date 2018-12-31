package src.Model.Product;

import src.Controller.Static;

public class Water extends Product {
    private double amount;

    public Water(double amount, double x, double y) {
        super(ProductType.WATER, Static.WATER_SELL_PRICE, Static.WATER_BUY_PRICE, Static.WATER_VOLUME, x, y);
        this.amount = amount;
    }

    public boolean useWater(double amount) {
        if (amount <= this.amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }
}