package Model.Animal.Pet.NoneProducer;

import Model.Animal.AnimalType;
import Model.Animal.Pet.Pet;

public abstract class NoneProducerAnimal extends Pet {
    public NoneProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

//    public void noneProducer();
}
