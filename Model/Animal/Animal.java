package Model.Animal;

import Model.Coordinate.Movement;
import Model.NTT;

public abstract class Animal extends NTT {
    Movement move = new Movement();
    double sellPrice, buyPrice;
    double volume;
}
