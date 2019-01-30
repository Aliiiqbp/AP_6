package Model.Vehicle;

import Controller.Static;
import Model.Salable;

public class Truck extends Vehicle {
    private double boxCount;
    private double boxCapacity;

    public Truck() {
        super(Static.TRUCK_CAPACITY_VOLUME_RADIUS_LVL_0 , Static.TRUCK_TRAVEL_DURATION_LVL_0);
        this.boxCapacity = Static.TRUCK_BOX_CAPACITY;
        this.boxCount = Static.TRUCK_BOX_COUNT_LVL_0;
    }

    public void sell(Salable salable, int count) {
        get(salable, count);
        // TODO: 12/30/2018 money
    }

    @Override
    public void upgradeLevel() { // TODO: 1/1/2019 increase Level
        switch (level){
            case 0 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_1 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_1);
                break;
            case 1 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_2 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_2);
                break;
            case 2 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_3 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_3);
                break;
            case 3 : //it's not upgradable :)
                break;
        }
        increaseLevel();
    }

    public void setBoxCount(double boxCount) {
        this.boxCount = boxCount;
    }
}