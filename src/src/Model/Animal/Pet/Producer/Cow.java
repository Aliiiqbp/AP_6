package src.Model.Animal.Pet.Producer;

import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Coordinate.Direction;
import src.Model.Product.Milk;
import src.Model.Product.Product;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;

import static src.Model.Coordinate.Direction.*;

public class Cow extends ProducerAnimal {
    public Cow(double x, double y) {
        super(AnimalType.COW, Static.COW_SELL_VALUE, Static.COW_BUY_COST, Static.COW_VOLUME, Static.COW_SPEED, x, y);
    }

    @Override
    public void play() {
        // TODO: 1/31/2019 eat and produce
        // TODO: 1/31/2019 move randomly
    }

    @Override
    public Product Produce() {
        return new Milk(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }

    public void ShowCow(Group root) {
        try {
            Image cowImage;
            if (this.animalState == AnimalState.EATING){
                cowImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Cow/EAT.png"));

            }else if (this.animalState == AnimalState.DYING){
                cowImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Cow/DEATH.png"));
            }else{
                cowImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Cow/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            }

            ImageView cowView = new ImageView(cowImage);
            cowView.setX(this.getMovement().getCurrentX());
            cowView.setY(this.getMovement().getCurrentY());
            root.getChildren().remove(lastImageView);

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
                    columns = 3;
                    cowView.setScaleX(-1);
                    break;

            }

            cowView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    cowView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
            lastImageView = cowView;
        } catch (Exception e) {
        }
    }
}
