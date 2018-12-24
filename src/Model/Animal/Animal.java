package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.NTT;

public abstract class Animal extends NTT {
    Movement move = new Movement();
    double sellPrice, buyPrice;
    double volume;
}
