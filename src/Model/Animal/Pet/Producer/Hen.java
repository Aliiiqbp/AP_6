package src.Model.Animal.Pet.Producer;

import src.Model.Animal.AnimalType;
import src.Model.Product.Egg;
import src.Model.Product.Product;

public class Hen extends ProducerAnimal {

    public Hen(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    @Override
    public Product Produce() {
        return new Egg();
    }
}
