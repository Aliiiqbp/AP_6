package src.Model;

import src.Controller.Static;

public abstract class Entity {
    public int level;
    public int maxLevel;// TODO: 12/30/2018 set it in constructor

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
        // TODO: 12/30/2018 with switch complete this function
    }

    public int getLevel() {
        return level;
    }
}
