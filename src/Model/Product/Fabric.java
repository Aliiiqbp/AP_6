package Model.Product;

import Controller.Static;

public class Fabric extends Product {
    public Fabric(double x, double y){
        super(ProductType.FABRIC, Static.FABRIC_SELL_VALUE, Static.FABRIC_BUY_COST, Static.FABRIC_VOLUME, x, y);
    }
}