package Model.Animal.Wild;

import Model.Animal.Animal;
import Model.Animal.AnimalState;
import Model.Animal.AnimalType;
import Model.Entity;
import Model.Farm.Map.Cell;
import Model.Farm.Map.Map;
import Model.Product.Product;
import Model.Product.ProductState;
import Model.Salable;

import java.util.ArrayList;

public abstract class Wild extends Animal {

    public Wild(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
    }

    public void destroy() {
        // TODO: 12/28/2018 we need to save destroyed objects
        Cell cell = getFarm().getMap().getMappedCell(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
        ArrayList<Entity> arrayList = cell.getSalables();
        int size = arrayList.size();
        for (Entity entity: arrayList) {
            if (entity.getClass().isInstance(Salable.class)) {
                if (entity.getClass().isInstance(Animal.class)) {
                    ((Animal) entity).changeState(AnimalState.DYING);
                } else if (entity.getClass().isInstance(Product.class)) {
                    ((Product) entity).changeProductState(ProductState.DESTROYED);
                }
                entity = null;
            }
        }
    } // TODO: 12/31/2018 it may change to private

    public void cage() {
        this.changeState(AnimalState.CAGED);
        this.getMovement().stop();
    } // TODO: 12/28/2018

    public void die() {
        this.changeState(AnimalState.DYING);
        this.getMovement().stop();
    } // TODO: 12/29/2018
}
