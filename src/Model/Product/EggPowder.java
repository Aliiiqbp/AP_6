package Model.Product;

import Controller.Static;

public class EggPowder extends Product {

    public EggPowder(double x, double y){
        super(ProductType.EGG_POWDER, Static.EGGPOWDER_SELL_VALUE, Static.EGGPOWDER_BUY_COST, Static.EGGPOWDER_VOLUME, x, y);
    }
}