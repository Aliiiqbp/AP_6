package src.Model.Animal.Pet.NoneProducer;

import src.Model.Farm.Extra.WareHouse;
import src.Model.Farm.Map.Map;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Animal.AnimalType;
import src.Model.Coordinate.Direction;
import src.Model.Coordinate.Movement;
import src.Model.Product.Product;
import src.Model.Salable;

import java.io.FileInputStream;

public class Cat extends NoneProducerAnimal {
    private Product product;

    public Cat(double x, double y) {
        super(AnimalType.CAT, Static.CAT_SELL_VALUE, Static.CAT_BUY_COST, Static.CAT_VOLUME, Static.CAT_SPEED, x, y);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override // catch
    public void play() {
        getTime().turn();
        if (product != null) {
            if (Map.isInSameCell(product.getMovement(), this.getMovement())) {
                getFarm().getMap().removeSalable(product);
                getFarm().getWareHouse().add(product);
                this.product = null;
            } else {
                this.getMovement().setDirection(Movement.bfs(this.getMovement(), product.getMovement()));
            }
        } else {
            Product target = findProduct();
            if (target != null) {
                product = target;
            } else {
                movement.setRandomDirection();
            }
        }

        move();
    }

    private Product findProduct() {
        for (Salable salable: getFarm().getMap().getSalables()) {
            if (salable.getClass().getSuperclass().getName().equals(Product.class.getName())) {
                return (Product) salable;
            }
        }
        return null;
    }

    public void ShowCat(Group root) {
        try {
            Image CatImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Cat/" + this.getMovement().getDirection() + ".png"));
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
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();

            root.getChildren().add(CatView);
            lastImageView = CatView;
        } catch (Exception e) {
        }
    }
}