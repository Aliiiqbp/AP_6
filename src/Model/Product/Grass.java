package src.Model.Product;

import src.Controller.Static;

public class Grass extends Product {
    private int maxGrass;
    private int currentGrass;

    public Grass(double x, double y){
        super(ProductType.GRASS, Static.GRASS_SELL_VALUE, Static.GRASS_BUY_COST, Static.GRASS_VOLUME, x, y);
        // TODO: 1/31/2019 fix max grass
    }

    public static Grass getGrass(double x, double y, Water water) {
        if (water != null) {
            water = null;
            return new Grass(x, y);
        }
        return null;
    }

    public void eaten() {
        if (canEaten()) {
            currentGrass -= 1;
            if (currentGrass == 0) {
                getFarm().getMap().removeSalable(this);
            }
        }
    }

    public boolean canEaten() {
        if (currentGrass > 0) {
            return true;
        }
        return false;
    }
}