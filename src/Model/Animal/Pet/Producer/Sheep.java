package src.Model.Animal.Pet.Producer;

import src.Model.Product.Product;
import src.Model.Product.Wool;

public class Sheep extends ProducerAnimal {
    @Override
    public Product Produce() {
        return new Wool();
    }
}
