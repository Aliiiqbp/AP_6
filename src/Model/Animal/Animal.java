package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.Entity;

public abstract class Animal extends Entity {
    Movement move = new Movement();
    double sellPrice, buyPrice;
    double volume;
}
