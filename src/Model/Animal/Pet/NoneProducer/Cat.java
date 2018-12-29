package src.Model.Animal.Pet.NoneProducer;

import src.Controller.Static;
import src.Model.Animal.AnimalType;

public class Cat extends NoneProducerAnimal {

    public Cat( double x, double y) {
        super(AnimalType.CAT, Static.CAT_SELL_VALUE, Static.CAT_BUY_COST, Static.CAT_VOLUME, Static.CAT_SPEED, x, y);

    }

    @Override // catch
    public void noneProducer() {

    }
}
