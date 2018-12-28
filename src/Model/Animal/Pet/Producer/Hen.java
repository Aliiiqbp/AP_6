package src.Model.Animal.Pet.Producer;

import src.Model.Product.Egg;
import src.Model.Product.Product;

public class Hen extends ProducerAnimal {

    @Override
    public Product Produce() {
        return new Egg();
    }
}
