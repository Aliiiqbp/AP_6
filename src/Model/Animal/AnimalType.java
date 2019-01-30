package Model.Animal;

import Model.Animal.Pet.NoneProducer.Cat;
import Model.Animal.Pet.NoneProducer.Dog;
import Model.Animal.Pet.Producer.Cow;
import Model.Animal.Pet.Producer.Hen;
import Model.Animal.Pet.Producer.Sheep;
import Model.Animal.Wild.Bear;
import Model.Animal.Wild.Lion;
import Model.Animal.Wild.Wild;

public enum AnimalType {
    HEN, COW, SHEEP, LION, BEAR, DOG, CAT;

    public static Animal getPet(AnimalType animalType, double x, double y) {
        Animal pet = null;
        switch (animalType) {
            case HEN: pet = new Hen(x, y);
                break;
            case COW: pet = new Cow(x, y);
                break;
            case SHEEP: pet = new Sheep(x, y);
                break;
            case DOG: pet = new Dog(x, y);
                break;
            case CAT: pet = new Cat(x, y);
                break;
            default: break;
        }

        return pet;
    }

    public static Wild getWild(AnimalType animalType, double x, double y) {
        Wild wild = null;
        switch (animalType) {
            case LION: wild = new Lion(x, y);
                break;
            case BEAR: wild = new Bear(x, y);
                break;
            default: break;
        }
        return wild;
    }
}
