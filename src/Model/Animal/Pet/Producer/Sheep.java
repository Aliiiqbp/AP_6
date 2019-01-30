package src.Model.Animal.Pet.Producer;

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
import src.Model.Product.Product;
import src.Model.Product.Wool;

import java.io.FileInputStream;

public class Sheep extends ProducerAnimal {
    public Sheep(double x, double y) {
        super(AnimalType.SHEEP, Static.SHEEP_SELL_VALUE, Static.SHEEP_BUY_COST, Static.SHEEP_VOLUME, Static.SHEEP_SPEED, x, y);
    }

    @Override
    public Product Produce() {
        return new Wool(this.getMovement().getCurrentX(), this.getMovement().getCurrentY());
    }


    public void ShowSheep(Group root, Direction direction) {
        try {
            Image sheepImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/Sheep/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView sheepView = new ImageView(sheepImage);
            sheepView.setX(this.getMovement().getCurrentX());
            sheepView.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) sheepImage.getWidth(), height = (int) sheepImage.getHeight();

            root.getChildren().add(sheepView);

            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    sheepView.setScaleX(-1);
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
                    sheepView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    sheepView.setScaleX(-1);
                    break;

            }

            sheepView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    sheepView,
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
