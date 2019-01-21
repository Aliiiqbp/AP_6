package src.Model.Animal.Wild;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.Pet;
import src.Model.Product.Product;

public abstract class Wild extends Animal {

    public Wild(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public void destroy(Pet pet, Product product) {
        // TODO: 12/28/2018 we need to save destroyed objects
        pet = null;
        product = null;
    } // TODO: 12/31/2018 it may change to private

    public void hunt() {
        this.changeState(AnimalState.HUNTED);
        this.getMovement().stop();
    } // TODO: 12/28/2018

    public void die() {
        this.changeState(AnimalState.DYING);
        this.getMovement().stop();
    } // TODO: 12/29/2018
}
