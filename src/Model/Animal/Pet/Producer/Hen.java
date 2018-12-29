package src.Model.Animal.Pet.Producer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Product.Egg;
import src.Model.Product.Product;

public class Hen extends ProducerAnimal {

    public Hen(double x, double y) {
        super(AnimalType.HEN, Static.HEN_SELL_VALUE, Static.HEN_BUY_COST, Static.HEN_VOLUME, Static.HEN_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Egg();
    }
}
