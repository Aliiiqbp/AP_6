package src.Model.Vehicle;

import src.Controller.Static;
import src.Model.Salable;

public class Helicopter extends Vehicle {
    public Helicopter() {
        super(Static.HELI_CAPACITY_VOLUME_RADIUS_LVL_0);
    }

    public void buy(Salable salable, int count) {
        addToList(salable, count);
        // TODO: 12/30/2018 money
    }
}
