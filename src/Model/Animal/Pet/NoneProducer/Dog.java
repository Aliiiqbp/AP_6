package src.Model.Animal.Pet.NoneProducer;

import src.Model.Animal.AnimalType;

public class Dog extends NoneProducerAnimal {

    public Dog(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    @Override // hunt
    public void noneProducer() {

    }
}
