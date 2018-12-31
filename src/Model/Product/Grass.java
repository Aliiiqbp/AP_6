package src.Model.Product;

import src.Controller.Static;

public class Grass extends Product {
    public Grass(double x, double y){
        super(ProductType.GRASS, Static.GRASS_sellPrice, Static.GRASS_buyPrice, Static.GRASS_Volume, x, y);
    }
}
