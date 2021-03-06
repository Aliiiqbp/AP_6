package src.Model.Animal.Pet.Producer;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import src.Model.Product.Egg;
import src.Model.Product.Product;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class Hen extends ProducerAnimal {

    public Hen(double x, double y) {
        super(AnimalType.HEN, Static.HEN_SELL_VALUE, Static.HEN_BUY_COST, Static.HEN_VOLUME, Static.HEN_SPEED, x, y, Static.HEN_HUNGRY_TIME, Static.HEN_DEATH_TIME, Static.HEN_EATING_TIME, ProductType.EGG);
    }

    @Override
    public Product Produce() {
        return new Egg(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }


    public void ShowHen(Group root) {
        try {
            Image henImage;
            if (this.animalState == AnimalState.EATING){
                henImage = new Image(new FileInputStream("src/Resources/Textures/Animals/GuineaFowl/EAT.png"));

            }else if (this.animalState == AnimalState.DYING){
                henImage = new Image(new FileInputStream("src/Resources/Textures/Animals/GuineaFowl/DEATH.png"));
            }else{
                henImage = new Image(new FileInputStream("src/Resources/Textures/Animals/GuineaFowl/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            }

            ImageView henView = new ImageView(henImage);
            henView.setX(this.getMovement().getCurrentX());
            henView.setY(this.getMovement().getCurrentY());
            root.getChildren().remove(lastImageView);

            final int count = 25;
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
                    columns = 5;
                    henView.setScaleX(-1);
                    break;

            }

            henView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    henView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
            lastImageView = henView;
        } catch (Exception e) {
        }
    }
}