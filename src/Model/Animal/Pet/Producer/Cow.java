package Model.Animal.Pet.Producer;

import Controller.Static;
import GUI.AnimalSpriteAnimation;
import Model.Animal.AnimalType;
import Model.Coordinate.Direction;
import Model.Product.Milk;
import Model.Product.Product;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;

import static Model.Coordinate.Direction.*;

public class Cow extends ProducerAnimal {
    public Cow(double x, double y) {
        super(AnimalType.COW, Static.COW_SELL_VALUE, Static.COW_BUY_COST, Static.COW_VOLUME, Static.COW_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Milk(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }

    public void showCow(Group root, Direction direction) {
        try {
            Image cowImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/Cow/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView cowView = new ImageView(cowImage);
            cowView.setX(this.getMovement().getCurrentX());
            cowView.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) cowImage.getWidth(), height = (int) cowImage.getHeight();

            root.getChildren().add(cowView);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    cowView.setScaleX(-1);
                    break;
                case DOWN:
                    columns = 6;
                    break;
                case DOWN_LEFT:
                    columns = 5;
                    ;
                    break;
                case LEFT:
                    columns = 6;
                    break;
                case UP_LEFT:
                    columns = 5;
                    break;
                case UP:
                    columns = 6;
                    break;
                case UP_RIGHT:
                    columns = 5;
                    cowView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    cowView.setScaleX(-1);
                    break;

            }

            cowView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    cowView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    width / columns, height / (count / columns)
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        } catch (Exception e) {
        }
    }
}
