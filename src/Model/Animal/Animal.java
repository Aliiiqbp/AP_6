package Model.Animal;

import javafx.scene.image.ImageView;
import Model.Coordinate.Movement;
import Model.Entity;
import Model.Salable;

public abstract class Animal extends Salable {
    protected AnimalType animalType;
    protected AnimalState animalState;
    protected ImageView lastImageView = null;

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

    public void changeState(AnimalState state) {
        this.animalState = state;
    }
}