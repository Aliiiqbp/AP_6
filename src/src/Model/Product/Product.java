package src.Model.Product;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Salable;

import java.io.FileInputStream;

public abstract class Product extends Salable {
    protected ProductType productType;
    protected ProductState productState;

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

    public void changeProductState(ProductState productState) {
        this.productState = productState;
    }

    public void showProduct(Group root) {
        try {
            Image productImage = new Image(new FileInputStream("src/Resources/Textures/Products/" + this.getProductType() + "/normal.png"));
            ImageView productView = new ImageView(productImage);
            productView.setX(this.getMovement().getCurrentX());
            productView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(productView);
        } catch (Exception e) {
        }
    }

    @Override
    public void play() {

    }
}