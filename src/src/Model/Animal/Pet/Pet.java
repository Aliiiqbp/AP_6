package src.Model.Animal.Pet;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;

public abstract class Pet extends Animal {
    public Pet(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }
}
