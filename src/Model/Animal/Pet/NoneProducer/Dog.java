package src.Model.Animal.Pet.NoneProducer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Wild.Wild;
import src.Model.Coordinate.Movement;
import src.Model.Product.Product;

public class Dog extends NoneProducerAnimal {

    public Dog(double x, double y) {
        super(AnimalType.DOG, Static.DOG_SELL_VALUE, Static.DOG_BUY_COST, Static.DOG_VOLUME, Static.DOG_SPEED, x, y);
    }

    @Override // hunt
    public void noneProducer() {

    }

    public void pursuit(Wild wild) {
        this.getMovement().setDirection(Movement.bfs(this.getMovement(), wild.getMovement()));
    }

    @Override
    public void upgradeLevel() {

    }
}
