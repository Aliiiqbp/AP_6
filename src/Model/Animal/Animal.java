package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.NTT;

public abstract class Animal extends NTT {
    Movement movement = new Movement();
    double sellPrice, buyPrice;
    double volume;

    public void move() {

    }
}
