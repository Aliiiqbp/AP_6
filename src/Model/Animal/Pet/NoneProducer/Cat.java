package src.Model.Animal.Pet.NoneProducer;

import src.Model.Animal.AnimalType;

public class Cat extends NoneProducerAnimal {

    public Cat(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    @Override // catch
    public void noneProducer() {

    }
}
