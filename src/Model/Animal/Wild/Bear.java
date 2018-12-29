package src.Model.Animal.Wild;

import src.Controller.Static;
import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;

public class Bear extends Wild {

    public Bear(double x, double y) {
        super(AnimalType.BEAR, Static.LION_SELL_VALUE, Static.LION_BUY_COST, Static.LION_VOLUME, Static.LION_SPEED, x, y);
    }
}