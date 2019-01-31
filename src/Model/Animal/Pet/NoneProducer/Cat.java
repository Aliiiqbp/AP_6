package Model.Animal.Pet.NoneProducer;

import Model.Farm.Extra.WareHouse;
import Model.Farm.Map.Map;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import Controller.Static;
import GUI.AnimalSpriteAnimation;
import Model.Animal.AnimalType;
import Model.Coordinate.Direction;
import Model.Coordinate.Movement;
import Model.Product.Product;

import java.io.FileInputStream;

public class Cat extends NoneProducerAnimal {
    private Product product;
    private boolean hasProduct;

    public Cat(double x, double y) {
        super(AnimalType.CAT, Static.CAT_SELL_VALUE, Static.CAT_BUY_COST, Static.CAT_VOLUME, Static.CAT_SPEED, x, y);
        hasProduct = false;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override // catch
    public void play() {
        if (product != null) {
            if (Map.isInSameCell(getFarm().getWareHouse().getMovement(), this.getMovement()) && hasProduct) {
                giveToCapacity();
                this.product = null;
                hasProduct = false;
            } else if (Map.isInSameCell(product.getMovement(), this.getMovement()) && !hasProduct) {
                catchProduct();
            } else if (!hasProduct){
                this.getMovement().setDirection(Movement.bfs(this.getMovement(), product.getMovement()));
            } else if(hasProduct) {
                this.getMovement().setDirection(Movement.bfs(this.movement, getFarm().getWareHouse().getMovement()));
            }
        } else {
            Product target = findProduct();
            if (target != null) {
                product = target;
            } else {
                // TODO: 1/31/2019 move randomly
            }
        }

    }

    private void giveToCapacity() {
        // TODO: 1/21/2019 change product state
        getFarm().getWareHouse().add(product);
        product = null;
    }

    private void catchProduct() {
        getFarm().getMap().removeSalable(product);
        hasProduct = true;
        // TODO: 1/31/2019 handle product place during cat moving
    }

    private Product findProduct() {
        // TODO: 1/31/2019 find nearest product
        return null;
    }

    public void ShowCat(Group root) {
        try {
            Image CatImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/Cat/" + this.getMovement().getDirection() + ".png"));
            ImageView CatView = new ImageView(CatImage);
            CatView.setX(this.getMovement().getCurrentX());
            CatView.setY(this.getMovement().getCurrentY());
            root.getChildren().remove(lastImageView);

            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) CatImage.getWidth(), height = (int) CatImage.getHeight();


            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 6;
                    CatView.setScaleX(-1);
                    break;
                case DOWN:
                    columns = 6;
                    break;
                case DOWN_LEFT:
                    columns = 6;
                    break;
                case LEFT:
                    columns = 4;
                    break;
                case UP_LEFT:
                    columns = 6;
                    break;
                case UP:
                    columns = 6;
                    break;
                case UP_RIGHT:
                    columns = 6;
                    CatView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 4;
                    CatView.setScaleX(-1);
                    break;

            }

            CatView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    CatView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    width / columns, height / (count / columns)
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();

            root.getChildren().add(CatView);
            lastImageView = CatView;
        } catch (Exception e) {
        }
    }
}