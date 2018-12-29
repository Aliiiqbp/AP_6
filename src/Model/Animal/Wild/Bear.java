package src.Model.Animal.Wild;

import src.Controller.Static;
import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;

public class Bear extends Wild {

    public Bear(double x, double y) {
        super(AnimalType.BEAR, Static.BEAR_SELL_VALUE, Static.BEAR_BUY_COST, Static.BEAR_VOLUME, Static.BEAR_SPEED, x, y);
    }
}