package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.Salable;

public abstract class Animal extends Salable {
    Movement move = new Movement();
    double sellPrice, buyPrice;
    double volume;
}
