package src.Network.Chat;

import java.io.Serializable;

public class Location implements Serializable {
    protected static final long serialVersionUID = 1112122201L;

    private boolean isInVillage;
    private String name;
    private double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isInVillage() {
        return isInVillage;
    }

    public String getName() {
        return name;
    }
}
