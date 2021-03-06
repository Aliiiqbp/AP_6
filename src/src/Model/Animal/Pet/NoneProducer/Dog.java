package src.Model.Animal.Pet.NoneProducer;

import src.Model.Animal.AnimalState;
import src.Model.Farm.Map.Map;
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
import src.Model.Product.Product;
import src.Model.Salable;

import java.io.FileInputStream;


public class Dog extends NoneProducerAnimal {

    private Wild wild;

    public Dog(double x, double y) {
        super(AnimalType.DOG, Static.DOG_SELL_VALUE, Static.DOG_BUY_COST, Static.DOG_VOLUME, Static.DOG_SPEED, x, y);
    }

    @Override // cage
    public void play() {
        getTime().turn();
        if (wild != null) {
            if (Map.isInSameCell(wild.getMovement(), this.movement)) {
                wild.die();
                this.die();
            } else {
                this.getMovement().setDirection(Movement.bfs(this.getMovement(), wild.getMovement()));
            }
        } else {
            Wild target = findWild();
            if (target != null) {
                this.wild = target;
            } else {
                movement.setRandomDirection();
            }
        }
        move();
    }

    private Wild findWild() {
        for (Salable salable: getFarm().getMap().getSalables()) {
            if (salable.getClass().getSuperclass().getName().equals(Wild.class.getName())) {
                return (Wild) salable;
            }
        }
        return null;
    }

    public void ShowDog(Group root) {
        try {
            Image dogImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Dog/" + this.getMovement().getDirection() + ".png"));
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
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();

            root.getChildren().add(dogView);
            lastImageView = dogView;
        } catch (Exception e) {
        }
    }
}
