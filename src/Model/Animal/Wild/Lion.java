package Model.Animal.Wild;

import Controller.Static;
import GUI.AnimalSpriteAnimation;
import Model.Animal.AnimalType;
import Model.Coordinate.Direction;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;

public class Lion extends Wild {

    public Lion(double x, double y) {
        super(AnimalType.LION, Static.LION_SELL_VALUE, Static.LION_BUY_COST, Static.LION_VOLUME, Static.LION_SPEED, x, y);
    }


    public void showLion(Group root, Direction direction) {
        try {
            Image lionImage = new Image(new FileInputStream("src/src/Resources/Textures/Animal/Africa/Lion/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView lionView = new ImageView(lionImage);
            lionView.setX(this.getMovement().getCurrentX());
            lionView.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) lionImage.getWidth(), height = (int) lionImage.getHeight();

            root.getChildren().add(lionView);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    lionView.setScaleX(-1);
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
                    lionView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    lionView.setScaleX(-1);
                    break;

            }

            lionView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    lionView,
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
