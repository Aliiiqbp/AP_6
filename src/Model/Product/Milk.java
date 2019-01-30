package Model.Product;

import Controller.Static;

public class Milk extends Product {

    public Milk(double x, double y) {
        super(ProductType.MILK, Static.MILK_SELL_VALUE, Static.MILK_BUY_COST, Static.MILK_VOLUME, x, y);
    }
}
