package src.Model;

import src.Controller.Static;
import src.Model.Farm.Farm;
import src.Model.Farm.Map.Map;

public abstract class Entity {
    public int level;
    private int maxLevel;
    private Farm farm;
    private Time time;

    public Entity() {
        level = Static.firstLevel;
        maxLevel = (int)Double.POSITIVE_INFINITY;
        time = new Time();
    }

    public boolean canUpgradeLevel(double money) {
        return false;
    }

    public double getUpgradeCost() {
        return 0;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel= maxLevel;
    }

    public void upgradeLevel() {
        if (level < maxLevel) {
            level++;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public Time getTime() {
        return time;
    }

    public abstract void play();
}
