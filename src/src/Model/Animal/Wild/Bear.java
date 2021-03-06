package src.Model.Animal.Wild;

import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Animal.AnimalState;
import src.Model.Animal.AnimalType;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;

public class Bear extends Wild {

    public Bear(double x, double y) {
        super(AnimalType.BEAR, Static.BEAR_SELL_VALUE, Static.BEAR_BUY_COST, Static.BEAR_VOLUME, Static.BEAR_SPEED, x, y);

    }

    public void ShowBear(Group root) {
        try {
            Image bearImage;
            if (this.animalState == AnimalState.CAGED){
                bearImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Bear/CAGED.png"));

            }else{
                bearImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Bear/" + this.getMovement().getDirection() + ".png"));
            }
            ImageView bearView = new ImageView(bearImage);
            bearView.setX(this.getMovement().getCurrentX());
            bearView.setY(this.getMovement().getCurrentY());

            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) bearImage.getWidth(), height = (int) bearImage.getHeight();

            root.getChildren().add(bearView);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    bearView.setScaleX(-1);
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
                    bearView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    bearView.setScaleX(-1);
                    break;

            }

            bearView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    bearView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        } catch (Exception e) {
        }
    }
}