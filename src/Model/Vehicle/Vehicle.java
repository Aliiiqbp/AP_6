package Model.Vehicle;

import Model.Capacity;
import Model.Entity;
import Model.Salable;

public abstract class Vehicle extends Entity {
    private Capacity capacity;
    public double travelDuration;

    public Vehicle(double capacityVolume , double travelDuration) {
        this.travelDuration = travelDuration;
        this.capacity = new Capacity(capacityVolume);
    }

//    public void addToList(Salable... salables) {
////        this.capacity.add(salables);
//    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void addToList(Salable salable) {
        this.capacity.add(salable);
    }

    public void get(Salable salable) {
        capacity.remove(salable);
    }

    public void clearLit() {
        this.capacity.clear();
    }

    public int getNumberOfSalable(Salable salable) {
        return this.capacity.getNumberOfSalable(salable.getClass().getName());
    }

    public void setTravelDuration(double travelDuration) {
        this.travelDuration = travelDuration;
    }

    public void setCapacity(double capacity) {
        this.capacity.update(capacity);
    }
}
