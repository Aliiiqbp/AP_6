package src.Model.Animal.Wild;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Entity;
import src.Model.Farm.Map.Cell;
import src.Model.Farm.Map.Map;
import src.Model.Product.Product;
import src.Model.Product.ProductState;
import src.Model.Salable;

import java.util.ArrayList;

public abstract class Wild extends Animal {

    protected int numberofclicks = 0;

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

    public void clicked(){
        ///// it should first make it caged
        if ( this.numberofclicks == 0){
            this.cage();
            this.numberofclicks ++;
        } else if (this.numberofclicks == 5){  // here it moves to warehouse
            this.getFarm().getWareHouse().add(this);
            this.getFarm().getMap().removeSalable(this);
        }
    }

    public void cage() {
        this.changeState(AnimalState.CAGED);
        this.getMovement().stop();
    }

    public void die() {
        this.changeState(AnimalState.DYING);
        this.getMovement().stop();
    } // TODO: 12/29/2018
}
