package src.Model;

import src.Controller.Static;

public class Entity {

    public int level;

    public Entity() {
        level = Static.firstLevel;
    }

    public boolean canUpgradeLevel(double money) {
        return false;
    }

    public double getUpgradeCost() {
        return 0;
    }

    public void upgradeLevel() {

    }

    public int getLevel() {
        return level;
    }
}