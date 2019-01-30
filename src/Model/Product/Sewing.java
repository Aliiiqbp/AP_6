package Model.Product;

import Controller.Static;

public class Sewing extends Product {

    public Sewing(double x, double y){
        super(ProductType.SEWING, Static.SEWING_SELL_VALUE, Static.SEWING_BUY_COST, Static.SEWING_VOLUME, x, y);
    }
}
