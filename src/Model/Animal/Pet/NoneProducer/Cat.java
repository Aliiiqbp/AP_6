package src.Model.Animal.Pet.NoneProducer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Coordinate.Movement;
import src.Model.Product.Product;

public class Cat extends NoneProducerAnimal {

    public Cat( double x, double y) {
        super(AnimalType.CAT, Static.CAT_SELL_VALUE, Static.CAT_BUY_COST, Static.CAT_VOLUME, Static.CAT_SPEED, x, y);

    }

    public void collect(Product product) {
        this.getMovement().setDirection(Movement.bfs(this.getMovement(), product.getMovement()));
    }


    @Override // catch
    public void noneProducer() {

    }
}
