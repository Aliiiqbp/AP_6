package src.Model.Product;

import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Salable;

public abstract class Product extends Salable {
    // TODO: 12/29/2018 add movement
    private ProductType productType;
    private ProductState productState;
    private Movement movement;

    public Product(ProductType productType, double sellPrice, double buyPrice, double volume, double x, double y) {
        super(sellPrice, buyPrice, volume);
        this.productType = productType;
        this.productState = ProductState.NONE;
        this.movement = new Movement(0.0, x, y);
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductState getProductState() {
        return productState;
    }

    public Movement getMovement() {
        return movement;
    }

    public void changePlace(ProductState productState) {
        this.productState = productState;
    }
}
