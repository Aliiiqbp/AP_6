package src.Model.Animal.Wild;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.NoneProducer.NoneProducerAnimal;
import src.Model.Animal.Pet.Producer.ProducerAnimal;
import src.Model.Entity;
import src.Model.Farm.Map.Cell;
import src.Model.Farm.Map.Map;
import src.Model.Product.Product;
import src.Model.Product.ProductState;
import src.Model.Salable;

import java.util.ArrayList;

public abstract class Wild extends Animal {

    public Wild(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public void destroy() {
        Cell cell = getFarm().getMap().getMappedCell(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
        ArrayList<Salable> arrayList = cell.getSalables();
        for (Salable salable: arrayList) {
            if (salable.getClass().getSuperclass().equals(NoneProducerAnimal.class) || salable.getClass().getSuperclass().equals(ProducerAnimal.class)) {
                ((Animal) salable).die();
            }
        }
    }

    public void cage() {
        this.getMovement().stop();
        this.changeState(AnimalState.CAGED);
    }

    @Override
    public void play() {
        getTime().turn();
        destroy();
        move();
    }
}
