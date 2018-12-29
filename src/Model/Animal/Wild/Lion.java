package src.Model.Animal.Wild;

import src.Controller.Static;
import src.Model.Animal.AnimalType;

public class Lion extends Wild {

    public Lion(double x, double y) {
        super(AnimalType.LION, Static.LION_SELL_VALUE, Static.LION_BUY_COST, Static.LION_VOLUME, Static.LION_SPEED, x, y);
    }
}
