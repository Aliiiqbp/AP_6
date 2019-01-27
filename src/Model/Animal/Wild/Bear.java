package src.Model.Animal.Wild;

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

import java.io.FileInputStream;

public class Bear extends Wild {

    public Bear(double x, double y) {
        super(AnimalType.BEAR, Static.BEAR_SELL_VALUE, Static.BEAR_BUY_COST, Static.BEAR_VOLUME, Static.BEAR_SPEED, x, y);
    }





    public void ShowBear(Group root) {
        try {
            Image bearImage = new Image(new FileInputStream("src/src/Resources/Textures/Bear/"+ this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView bearImage = new ImageView(bearImage);
            bearImage.setX(this.getMovement().getCurrentX());
            bearImage.setY(this.getMovement().getCurrentY());

//double dsgf = bearImage.getFitWidth()
            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) bearImage.getWidth(), height = (int) bearImage.getHeight();

            root.getChildren().add(bearImage);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    bearImage.setScaleX(-1);
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
                    bearImage.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    bearImage.setScaleX(-1);
                    break;

            }

            bearImage.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    bearImage,
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