package src.Model.Vehicle;

import src.Controller.Static;
import src.Model.Salable;

public class Truck extends Vehicle {
    public Truck() {
        super(Static.TRUCK_CAPACITY_VOLUME_RADIUS_LVL_0);
    }

    public void sell(Salable salable, int count) {
        get(salable, count);
        // TODO: 12/30/2018 money
    }
}