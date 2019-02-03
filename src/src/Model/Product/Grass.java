package src.Model.Product;

import src.Controller.Static;

public class Grass extends Product {
    private int maxGrass;
    private int currentGrass;

    public Grass(double x, double y){
        super(ProductType.GRASS, Static.GRASS_SELL_VALUE, Static.GRASS_BUY_COST, Static.GRASS_VOLUME, x, y);
        this.maxGrass = Static.GRASS_MAX_GRASS;
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