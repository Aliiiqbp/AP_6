package Model;

import Controller.Static;

import java.util.ArrayList;

public class NTT {

    public int level;

    public NTT() {
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
