package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.Entity;

public abstract class Animal extends Entity {
    private AnimalType animalType;
    private Movement movement;
    private double sellPrice, buyPrice;
    private double volume;
    private AnimalState animalState;

    public Animal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y ) {
        this.animalType = animalType;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.volume = volume;
        this.animalState = AnimalState.None;
        movement = new Movement(speed, x, y);
    }

    public void move() {
        movement.move();
    }
}
