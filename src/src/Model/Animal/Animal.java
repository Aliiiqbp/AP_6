package src.Model.Animal;

import javafx.scene.image.ImageView;
import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Farm.Map.Cell;
import src.Model.Salable;

public abstract class Animal extends Salable {
    protected AnimalType animalType;
    protected AnimalState animalState;
    protected ImageView lastImageView = null;
    protected Movement movement;

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

    public abstract void play();

    public void die() {
        this.changeState(AnimalState.DYING);
        this.getMovement().stop();
        this.getFarm().getMap().removeSalable(this);
    }

    public void changeState(AnimalState state) {
        this.animalState = state;
    }
}