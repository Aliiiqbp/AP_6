package src.Model.Animal.Pet.NoneProducer;

import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.Pet;

public abstract class NoneProducerAnimal extends Pet {
    public NoneProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public abstract void noneProducer();

//    public void noneProducer();
}
