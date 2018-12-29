package src.Model;

import src.Controller.Static;

import java.util.ArrayList;
import java.util.HashMap;

public class Capacity { //this class created for WareHouse and Vehicles

    private double capacityVolume;
    private double occupiedCapacity;
    private ArrayList<Salable> salables = new ArrayList<>();
    private HashMap<Salable, Integer> map = new HashMap<>();


    public Capacity(double capacityVolume) {
        this.capacityVolume = capacityVolume;
        occupiedCapacity = 0; // TODO: 12/29/2018  firstOccupiedCapacity
    }

    public void add(Salable salable, int count) {
        // TODO: 12/29/2018
    }

    public void get(Salable salable, int count) {
        // TODO: 12/29/2018
    }

    public void clear() {
        // TODO: 12/29/2018
    }


}
