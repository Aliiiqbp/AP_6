package src.Model;

import src.Controller.Static;
import src.Model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Capacity { //this class created for WareHouse and Vehicles
    private double capacityVolume;
    private double occupiedCapacity;
    private HashMap<String, Integer> hashMap;
    private ArrayList<Salable> list = new ArrayList<>();

    public Capacity(double capacityVolume) {
        this.capacityVolume = capacityVolume;
        occupiedCapacity = Static.FIRST_OCCUPIED_CAPACITY;
        hashMap = new HashMap<>();
    }

    public double getCapacityVolume() {
        return capacityVolume;
    }

    public double getOccupiedCapacity() {
        return occupiedCapacity;
    }

    public void add(Salable salable) {
        String salableName = salable.getClass().getName();
        if (canAdd(salable)) {
            if (hashMap.containsKey(salableName)) {
                hashMap.replace(salableName, hashMap.get(salableName) + 1);
            } else {
                hashMap.put(salableName, 1);
                list.add(salable);
            }
            occupiedCapacity += salable.getVolume();
        }
    }

//    public void add(Salable salable, int count) {
//        String salableName = salable.getClass().getName();
//        double totalVolume = salable.getVolume() * count;
//        if (canAdd(salable, count)) { // if not this function does not thing
//            if (hashMap.containsKey(salableName)) {
//                hashMap.replace(salableName, hashMap.get(salableName) + count);
//            } else {
//                hashMap.put(salableName, count);
//                list.add(salableName);
//            }
//            occupiedCapacity += totalVolume;
//        }
//    }

    public void add(ArrayList<Salable> salables) {
        if (canAdd(salables)) {
            for (Salable salable : salables) {
            add(salable);
            }
        }
    }

    // TODO: 1/22/2019 maybe we need remove in other type

    public void remove(Salable salable) {
        String salableName = salable.getClass().getName();
        if (hashMap.containsKey(salableName)) {
            int numberOfSalable = hashMap.get(salableName);
            if (numberOfSalable > 1) {
                hashMap.replace(salableName, numberOfSalable - 1);
            } else {
                hashMap.remove(salableName);
            }
            Salable s = searchSalable(salable);
            occupiedCapacity -= s.getVolume();
            list.remove(s);
        }
    }

    public Salable getSalable(Salable salable) {
        if (contain(salable)) {
            String name = salable.getClass().getName();
            int numberOfSalable = hashMap.get(name);
            if (numberOfSalable > 1) {
                hashMap.replace(name, numberOfSalable - 1);
            } else {
                hashMap.remove(name);
            }
            Salable s = searchSalable(salable);
            occupiedCapacity -= s.getVolume();
            list.remove(s);
            return s;
        }
        return null;
    }

    private Salable searchSalable(Salable salable) {
        String name = salable.getClass().getName();
        for (Salable s:list) {
            if (s.getClass().getName() == name) {
                return s;
            }
        }
        return null;
    }

//    public void remove(Salable salable, int count) {
//        String salableName = salable.getClass().getName();
//        if (hashMap.containsKey(salableName)) {
//            int numberOfSalable = hashMap.get(salableName);
//            if (numberOfSalable >= count) {
//                if (count == numberOfSalable) {
//                    hashMap.remove(salableName);
//                    list.remove(salableName);
//                } else {
//                    hashMap.replace(salableName, numberOfSalable - count);
//                }
//                occupiedCapacity -= count * salable.getVolume();
//            }
//        }
//    }

    public void clear() {
        hashMap.clear();
        list.clear();
    }

    public int getNumberOfSalable(String string) {
        return hashMap.containsKey(string) ? hashMap.get(string) : 0;
    }

    public boolean canAdd(Salable salable) {
        if (salable.volume <= (capacityVolume - occupiedCapacity)) {
            return true;
        }
        return false;
    }

//    public boolean canAdd(Salable salable, int count) {
//        if (salable.getVolume()*count <= (capacityVolume - occupiedCapacity)) {
//            return true;
//        }
//        return false;
//    }

    public boolean canAdd(ArrayList<Salable> salables) {
        double totalVolume = 0;
        for (Salable salable: salables) {
            totalVolume += salable.getVolume();
        }
        if (totalVolume <= (capacityVolume - occupiedCapacity)) {
            return true;
        }
        return false;
    }

    public boolean contain(Salable salable) {
        String name = salable.getClass().getName();
        if (hashMap.containsKey(name)) {
            int n = hashMap.get(name);
            if (n > 0) { //is not necessary
                return true;
            }
        }
        return false;
    }

    public ArrayList<Salable> getList() {
        return list;
    }

    public void update(double capacityVolume) {
        // TODO: 12/30/2018 it is need to overwrite in all objects
        this.capacityVolume = capacityVolume;
    }

    public int getNumber(String string) {
        return hashMap.get(string);
    }
}
