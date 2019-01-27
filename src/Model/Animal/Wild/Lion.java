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

public class Lion extends Wild {

    public Lion(double x, double y) {
        super(AnimalType.LION, Static.LION_SELL_VALUE, Static.LION_BUY_COST, Static.LION_VOLUME, Static.LION_SPEED, x, y);
    }



    public void showLion(Group root, Direction direction) {
        try {
            Image lionImage = new Image(new FileInputStream("src/src/Resources/Textures/Animal/Africa/Lion/"+this.getMovement().getDirection()+".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView lionImage = new ImageView(lionImage);
            lionImage.setX(this.getMovement().getCurrentX());
            lionImage.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int)lionImage.getWidth(), height = (int)lionImage.getHeight();

            root.getChildren().add(lionImage);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    lionImage.setScaleX(-1);
                    break;
                case DOWN:
                    columns = 6;
                    break;
                case DOWN_LEFT:
                    columns = 5;;
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
                    lionImage.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    lionImage.setScaleX(-1);
                    break;

            }

            lionImage.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    lionImage,
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


}
