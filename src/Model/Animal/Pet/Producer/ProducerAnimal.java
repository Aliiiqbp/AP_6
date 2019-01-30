package Model.Animal.Pet.Producer;

import Model.Animal.AnimalType;
import Model.Animal.Pet.Pet;
import Model.Product.Product;

public abstract class ProducerAnimal extends Pet {
    public ProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public abstract Product Produce();

//    public Product Produce();
}
