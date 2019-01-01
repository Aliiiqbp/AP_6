package src.Model.Vehicle;

import src.Model.Capacity;
import src.Model.Entity;
import src.Model.Salable;

public abstract class Vehicle extends Entity {
    Capacity capacity;
    public double travelDuration;

    public Vehicle(double capacityVolume , double travelDuration) {
        this.travelDuration = travelDuration;
        this.capacity = new Capacity(capacityVolume);
    }

    public double getCapacityVolume() {
        return this.capacity.getCapacityVolume();
    }

    public double getOccupiedCapacity() {
        return this.capacity.getOccupiedCapacity();
    }

    public void addToList(Salable... salables) {
        this.capacity.add(salables);
    }

    public void addToList(Salable salable, int count) {
        this.capacity.add(salable, count);
    }

    public void get(Salable salable, int count) {
        capacity.get(salable, count);
    }

    public void clearLit() {
        this.capacity.clear();
    }

    public int getNumberOfSalable(Salable salable) {
        return this.capacity.getNumberOfSalable(salable);
    }

    public String getList() {
        return this.capacity.getList();
    }

//    public void update() {
//        this.capacity.update();
//    }

    public void setTravelDuration(double travelDuration) {
        this.travelDuration = travelDuration;
    }
}
