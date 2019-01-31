package src.Model.Product;

import src.Controller.Static;

public class Cake extends Product {

    public Cake(double x, double y) {
        super(ProductType.EGG, Static.CAKE_SELL_VALUE, Static.CAKE_BUY_COST, Static.CAKE_VOLUME, x, y);
    }
}