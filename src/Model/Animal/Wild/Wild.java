package src.Model.Animal.Wild;

import src.Model.Animal.Animal;
import src.Model.Animal.Pet.Pet;
import src.Model.Product.Product;

import java.security.PublicKey;

public abstract class Wild extends Animal {

    public void destroy(Pet pet, Product product) {
        pet = null;
        product = null;
    }

    public void move() {

    }

    public void hunt() {} // TODO: 12/28/2018
}
