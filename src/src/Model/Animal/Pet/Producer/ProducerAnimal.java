package src.Model.Animal.Pet.Producer;

import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.Pet;
import src.Model.Coordinate.Movement;
import src.Model.Farm.Map.Map;
import src.Model.Product.Grass;
import src.Model.Product.Product;
import src.Model.Product.ProductType;
import src.Model.Salable;

public abstract class ProducerAnimal extends Pet {

    private ProductType product;
    private Grass grass;
    private int hungryTime;
    private int deathTime;
    private int eatingTime;
    private boolean isHungry;

    public ProducerAnimal(AnimalType animalType, double sellPrice, double buyPrice, double volume, double speed, double x, double y, int hungryTime, int deathTime, int eatingTime, ProductType product) {
        super(animalType, sellPrice, buyPrice, volume, speed, x, y);
        this.hungryTime = hungryTime;
        this.deathTime = deathTime;
        this.eatingTime = eatingTime;
        this.product = product;
    }

    public Product Produce() {
        return ProductType.getProduct(product, this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }
    
    public void play() {
        getTime().turn();
        if (!isHungry) {
            if (getTime().getDuration() >= hungryTime) {
                isHungry = true;
                this.movement.boostSpeed();
                getTime().restart();
            }
            movement.setRandomDirection();
        } else {
            if (animalState == AnimalState.EATING) {
                 if (getTime().getDuration() >= eatingTime) {
                     getTime().restart();
                     animalState = AnimalState.NONE;
                     grass.eaten();
                     isHungry = false;
                 }
            } else {
                if (getTime().getDuration() >= deathTime) {
                    getTime().restart();
                    animalState = AnimalState.DYING;
                    getFarm().getMap().removeSalable(this);
                    return;
                }
                if (grass != null) {
                    if (Map.isInSameCell(grass.getMovement(), this.getMovement())) {
                        movement.stop();
                        movement.reduceSpeed();
                        animalState = AnimalState.EATING;
                    } else {
                        Movement.bfs(this.movement, grass.getMovement());
                    }
                } else {
                    findGrass();
                }
            }
        }

        move();

    }
    
    private Grass findGrass() {
        for (Salable salable: getFarm().getMap().getSalables()) {
            if (salable.getClass().equals(Grass.class)) {
                return (Grass) salable;
            }
        }
        return null;
    }
}
