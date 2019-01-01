package src.Model;

import src.Controller.Static;

import java.util.ArrayList;
import java.util.HashMap;

public class Capacity { //this class created for WareHouse and Vehicles

    private double capacityVolume;
    private double occupiedCapacity;
//    private ArrayList<Salable> salableArray = new ArrayList<>();
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private ArrayList<String> list = new ArrayList<>();


    public Capacity(double capacityVolume) {
        this.capacityVolume = capacityVolume;
        occupiedCapacity = Static.FIRST_OCCUPIED_CAPACITY;
    }

    public double getCapacityVolume() {
        return capacityVolume;
    }

    public double getOccupiedCapacity() {
        return occupiedCapacity;
    }

    // TODO: 12/30/2018 handle both add and get
    public void add(Salable... salables) {
        double totalVolumeToAdd = 0;
        for (Salable salable: salables) {
            totalVolumeToAdd += salable.getVolume();
        }

        if (totalVolumeToAdd <= (capacityVolume - occupiedCapacity)) { // if not this function does not thing
            for (Salable salable: salables) {
                if (hashMap.containsKey(salable.getClass().getName())) {
                    hashMap.replace(salable.getClass().getName(), hashMap.get(salable.getClass().getName()) + 1);
//                    salableArray.add(salable);
                    list.add(salable.getClass().getName());
                } else {
                    hashMap.put(salable.getClass().getName(), 1);
//                    salableArray.add(salable);
                    list.add(salable.getClass().getName());
                }
            }
            occupiedCapacity += totalVolumeToAdd;
        }
    }
    
    public void add(Salable salable, int count) {
        double totalVolumeToAdd = salable.getVolume()*count;
        if (totalVolumeToAdd <= (capacityVolume - occupiedCapacity)) { // if not this function does not thing
            if (hashMap.containsKey(salable.getClass().getName())) {
                hashMap.replace(salable.getClass().getName(), hashMap.get(salable.getClass().getName()) + count);
//                    salableArray.add(salable);
//                list.add(salable.getClass().getName());
            } else {
                hashMap.put(salable.getClass().getName(), count);
//                    salableArray.add(salable);
                list.add(salable.getClass().getName());
            }
        }
    }

    public void get(Salable salable, int count) {
        if (hashMap.containsKey(salable.getClass().getName())) {
            int numberOfSalable = hashMap.get(salable.getClass().getName());
            if (numberOfSalable >= count) {
//            int i = 0;
//            int j = 0;
//            while (i < numberOfSalable) {
//                if (salableArray.get(j).getClass().equals(salable.getClass())) {
//                    i++;
//                    salableArray.remove(j);
//                } else {
//                    j++;
//                }
//            }
                hashMap.replace(salable.getClass().getName(), numberOfSalable - count);
                if (numberOfSalable == count) {
                    list.remove(salable.getClass().getName());
                }
            }
        }
        // TODO: 12/31/2018 send error message
    }

    public void clear() {
        hashMap.clear();
//        salableArray.clear();
        list.clear();
    }

    public int getNumberOfSalable(Salable salable) {
        if (hashMap.containsKey(salable.getClass().getName())) {
            return hashMap.get(salable.getClass().getName());
        } else {
            return 0;
        }
    }

    public String getList() {
        String string = "";
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            string += list.get(i) + ": " + hashMap.get(list.get(i)) +"\n";
        }
        return string;
    }

    public void update(double capacityVolume) {
        // TODO: 12/30/2018 it is need to overwrite in all objects
        this.capacityVolume = capacityVolume;
    }
}
