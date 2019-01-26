package src.Model.Animal.Pet.NoneProducer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Wild.Wild;
import src.Model.Coordinate.Movement;
import src.Model.Product.Product;

public class Dog extends NoneProducerAnimal {

    private Wild wild;

    public Dog(double x, double y) {
        super(AnimalType.DOG, Static.DOG_SELL_VALUE, Static.DOG_BUY_COST, Static.DOG_VOLUME, Static.DOG_SPEED, x, y);
    }

    @Override // cage
    public void noneProducer() {
        if (wild != null) {
            this.getMovement().setDirection(Movement.bfs(this.getMovement(), wild.getMovement()));
        }
    }

    public void setWild(Wild wild) {
        this.wild = wild;
    }
}
