package src.Model.Animal.Pet.NoneProducer;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Wild.Wild;
import src.Model.Coordinate.Direction;
import src.Model.Coordinate.Movement;

import java.io.FileInputStream;


public class Dog extends NoneProducerAnimal {

    private Wild wild;


    public Dog(double x, double y) {
        super(AnimalType.DOG, Static.DOG_SELL_VALUE, Static.DOG_BUY_COST, Static.DOG_VOLUME, Static.DOG_SPEED, x, y);
    }

    @Override // cage
    public void noneProducer() {
        if (wild != null) {
            this.getMovement().setDirection(Movement.bfs(this.getMovement(), wild.getMovement()));
        }
    }

    public void setWild(Wild wild) {
        this.wild = wild;
    }

    public void ShowDog(Group root) {
        try {
            Image dogImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/Dog/" + this.getMovement().getDirection() + ".png"));
            ImageView dogView = new ImageView(dogImage);
            dogView.setX(this.getMovement().getCurrentX());
            dogView.setY(this.getMovement().getCurrentY());
            root.getChildren().remove(lastImageView);

            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = (int) dogImage.getWidth(), height = (int) dogImage.getHeight();


            switch (this.getMovement().getDirection()) {
                case DOWN_RIGHT:
                    columns = 5;
                    dogView.setScaleX(-1);
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
                    dogView.setScaleX(-1);
                    break;
                case RIGHT:
                    columns = 6;
                    dogView.setScaleX(-1);
                    break;

            }

            dogView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    dogView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    width / columns, height / (count / columns)
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();

            root.getChildren().add(dogView);
            lastImageView = dogView;
        } catch (Exception e) {
        }
    }
}
