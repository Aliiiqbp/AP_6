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

//        @Override
//        public void start(Stage primaryStage) throws Exception {
//            Group root = new Group();
//            Scene scene = new Scene(root, 300, 400);
//            //image in javafx
        try {
            Image animalImage = new Image(new FileInputStream("src/Resources/Textures/Animals/Africa/Dog/down.png")); // TODO: 01/25/2019 get correct address for animations
            ImageView animalView = new ImageView(animalImage);
            animalView.setX(20);
            animalView.setY(20);


            root.getChildren().add(animalView);

            animalView.setViewport(new Rectangle2D(0, 0, 354, 880));
//sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    animalView,
                    Duration.millis(2000),
                    24, 3,
                    0, 0,
                    // 64=829/13
                    118, 110
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        } catch (Exception e) {
        }

    }
}
