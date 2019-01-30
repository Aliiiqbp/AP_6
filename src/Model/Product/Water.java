package Model.Product;

import Controller.Static;

public class Water extends Product {

    public Water(double x, double y) {
        super(ProductType.WATER, Static.WATER_SELL_PRICE, Static.WATER_BUY_PRICE, Static.WATER_VOLUME, x, y);
    }
}