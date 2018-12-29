package src.Model.Animal.Pet.Producer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Product.Milk;
import src.Model.Product.Product;

public class Cow extends ProducerAnimal {
    public Cow( double x, double y) {
        super(AnimalType.COW, Static.COW_SELL_VALUE, Static.COW_BUY_COST, Static.COW_VOLUME, Static.COW_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Milk();
    }
}
