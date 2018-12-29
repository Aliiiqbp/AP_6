package src.Model.Animal.Pet.NoneProducer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;

public class Dog extends NoneProducerAnimal {

    public Dog(double x, double y) {
        super(AnimalType.DOG, Static.DOG_SELL_VALUE, Static.DOG_BUY_COST, Static.DOG_VOLUME, Static.DOG_SPEED, x, y);
    }

    @Override // hunt
    public void noneProducer() {

    }
}
