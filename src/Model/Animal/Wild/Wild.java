package src.Model.Animal.Wild;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.Pet;
import src.Model.Product.Product;

import java.security.PublicKey;

public abstract class Wild extends Animal {

    public Wild(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public void destroy(Pet pet, Product product) {
        // TODO: 12/28/2018 we need to save destroyed objects
        pet = null;
        product = null;
    }

    public void hunt() {

    } // TODO: 12/28/2018

    public void die() {} // TODO: 12/29/2018
}
