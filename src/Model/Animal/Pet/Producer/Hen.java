package Model.Animal.Pet.Producer;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import Controller.Static;
import GUI.AnimalSpriteAnimation;
import Model.Animal.AnimalType;
import Model.Product.Egg;
import Model.Product.Product;

import java.io.FileInputStream;

public class Hen extends ProducerAnimal {

    public Hen(double x, double y) {
        super(AnimalType.HEN, Static.HEN_SELL_VALUE, Static.HEN_BUY_COST, Static.HEN_VOLUME, Static.HEN_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Egg(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }


    public void ShowHen(Group root) {
        try {
            Image henImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/GuineaFowl/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView henView = new ImageView(henImage);
            henView.setX(this.getMovement().getCurrentX());
            henView.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) henImage.getWidth(), height = (int) henImage.getHeight();

            root.getChildren().add(henView);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    henView.setScaleX(-1);
                    break;
                case DOWN:
                    columns = 6;
                    break;
                case DOWN_LEFT:
                    columns = 5;
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
                    henView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    henView.setScaleX(-1);
                    break;

            }

            henView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    henView,
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