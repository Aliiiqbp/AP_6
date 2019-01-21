package src.Model.Animal.Pet.Producer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Product.Product;
import src.Model.Product.Wool;

public class Sheep extends ProducerAnimal {
    public Sheep( double x, double y) {
        super(AnimalType.SHEEP, Static.SHEEP_SELL_VALUE, Static.SHEEP_BUY_COST, Static.SHEEP_VOLUME, Static.SHEEP_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Wool(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }
}
