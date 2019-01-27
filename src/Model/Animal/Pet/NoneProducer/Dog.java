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
            Image dogImage = new Image(new FileInputStream("src/src/Resources/Textures/Animals/Africa/Dog/" + this.getMovement().getDirection() + ".png")); // TODO: 01/25/2019 get correct address for animations
            ImageView dogView = new ImageView(dogImage);
            dogView.setX(this.getMovement().getCurrentX());
            dogView.setY(this.getMovement().getCurrentY());


            final int count = 24;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 0, width = 0, height = 0;

            root.getChildren().add(dogView);

            switch (direction) {
                case DOWN_RIGHT:
                    columns = 5;
                    dogView.setScaleX(-1);
                    width = 460;
                    height = 420;
                    break;
                case DOWN:
                    columns = 6;
                    width = 396;
                    height = 336;
                    break;
                case DOWN_LEFT:
                    columns = 5;
                    width = 460;
                    height = 420;
                    break;
                case LEFT:
                    columns = 6;
                    width = 648;
                    height = 344;
                    break;
                case UP_LEFT:
                    columns = 5;
                    width = 460;
                    height = 490;
                    break;
                case UP:
                    columns = 6;
                    width = 396;
                    height = 400;
                    break;
                case UP_RIGHT:
                    columns = 5;
                    dogView.setScaleX(-1);
                    width = 460;
                    height = 490;
                    break;
                case RIGHT:
                    columns = 6;
                    dogView.setScaleX(-1);
                    width = 648;
                    height = 344;
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
        } catch (Exception e) {
        }
    }
}
