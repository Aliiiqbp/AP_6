package src.Model.Animal.Pet.Producer;

import src.Model.Product.Milk;
import src.Model.Product.Product;

public class Cow extends ProducerAnimal {
    @Override
    public Product Produce() {
        return new Milk();
    }
}
