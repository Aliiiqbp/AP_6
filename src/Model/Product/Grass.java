package src.Model.Product;

import src.Controller.Static;

public class Grass extends Product {
    public Grass(double x, double y){
        super(ProductType.GRASS, Static.GRASS_SELL_VALUE, Static.GRASS_BUY_COST, Static.GRASS_VOLUME, x, y);
    }
}