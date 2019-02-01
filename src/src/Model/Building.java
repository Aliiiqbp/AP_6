package src.Model;

import src.Model.Coordinate.Movement;

public class Building extends Entity{
    protected Movement movement;

    // TODO: 1/31/2019 set constructor
    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return movement;
    }
}
