package Model.Product;

import Controller.Static;

public class Plume extends Product{

    public Plume(double x, double y) {
        super(ProductType.PLUME, Static.PLUME_SELL_VALUE, Static.PLUME_BUY_COST, Static.PLUME_VOLUME, x, y);
    }
}
