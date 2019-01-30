package src.Model.Animal.Pet.Producer;

import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.Pet;
import src.Model.Product.Product;

public abstract class ProducerAnimal extends Pet {
    public ProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public abstract Product Produce();

//    public Product Produce();
}
