package src.Model.Animal;

import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Salable;

public abstract class Animal extends Salable {
    private AnimalType animalType;
    private AnimalState animalState;
    private Movement movement;

    public Animal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y ) {
        super(sellPrice, buyPrice, volume);
        this.animalType = animalType;
        this.animalState = AnimalState.NONE;
        this.movement = new Movement(speed, x, y);
    }

    public void move() {
        movement.move();
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public AnimalState getAnimalState() {
        return animalState;
    }

    public Movement getMovement() {
        return movement;
    }

    public void changeState(AnimalState state) {
        this.animalState = state;
    }
}