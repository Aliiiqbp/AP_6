package Model.Animal.Pet.Producer;

import Model.Animal.AnimalType;
import Model.Animal.Pet.Pet;
import Model.Coordinate.Movement;
import Model.Farm.Map.Map;
import Model.Product.Grass;
import Model.Product.Product;
import Model.Product.ProductType;

public abstract class ProducerAnimal extends Pet {

    private ProductType product;
    private Grass grass;
    private double hungryTime;
    private boolean isHungry;
    // TODO: 1/31/2019 handle time

    public ProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
        // TODO: 1/31/2019 set product and hungryTime
    }

    public Product Produce() {
        return ProductType.getProduct(product, this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }
    
    public void play() {
        // TODO: 1/31/2019 handle eating time

        if (isHungry) {
            this.movement.boostSpeed();
            if (grass != null) {
                if (Map.isInSameCell(grass.getMovement(), this.getMovement())) {
                    eat();
                } else {
                    Movement.bfs(this.movement, grass.getMovement());
                }
            } else {
                findGrass();
            }
        } else {
            //walk randomly
        }

    }
    
    private void findGrass() {
        // TODO: 1/31/2019  
    }

    private void eat() {
        //run thread
        isHungry = false;
    }

//    public Product Produce();
}
