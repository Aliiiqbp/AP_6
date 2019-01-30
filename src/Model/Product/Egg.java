package src.Model.Product;

import src.Controller.Static;

public class Egg extends Product {

    public Egg(double x, double y) {
        super(ProductType.EGG, Static.EGG_SELL_VALUE, Static.EGG_BUY_COST, Static.EGG_VOLUME, x, y);
    }

}
