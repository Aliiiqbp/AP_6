package src.Model.Vehicle;

import src.Controller.Static;
import src.Model.Salable;

public class Helicopter extends Vehicle {
    private double scatteringRadius;

    public Helicopter() {
        super(Static.HELI_CAPACITY_VOLUME_RADIUS_LVL_0, Static.HELI_TRAVEL_DURATION_LVL_0);
        this.scatteringRadius = Static.HELI_SCATTERING_RADIUS_LVL_0;
    }

    public void buy(Salable salable, int count) {
        addToList(salable, count);
        // TODO: 12/30/2018 money
    }

    @Override
    public void upgradeLevel() {
        switch (level){
            case 0 : this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_1 );
                     this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_1);
                     break;
            case 1 : this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_2 );
                this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_2);
                break;
            case 2 : this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_3 );
                this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_3);
                break;
            case 3 : //it's not upgradable :)
                break;
        }

    }

    public void setScatteringRadius(double scatteringRadius) {
        this.scatteringRadius = scatteringRadius;
    }

    public double getScatteringRadius() {
        return scatteringRadius;
    }
}
