package Model.Product;

import Controller.Static;

public class Flour extends Product {

    public Flour(double x, double y) {
        super(ProductType.FLOUR, Static.FLOUR_SELL_VALUE, Static.FLOUR_BUY_COST, Static.FLOUR_VOLUME, x, y);
    }
}
