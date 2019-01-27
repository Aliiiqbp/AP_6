package src.GUI;


import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.Model.Coordinate.Direction;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileInputStream;
import java.security.acl.Group;

public class AnimalAnimation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 400);
        //image in javafx
        Direction direction = Direction.DOWN;
        System.out.println(direction);
        Image animalImage = new Image(new FileInputStream("src/src/Resources/Textures/Cow/"+ direction +".png")); // TODO: 01/25/2019 get correct address for animations
        ImageView animalView = new ImageView(animalImage);
        animalView.setX(20);
        animalView.setY(20);

        root.getChildren().add(animalView);

        animalView.setViewport(new Rectangle2D(0, 0, 354, 880));

        final Animation animation = new AnimalSpriteAnimation(
                animalView,
                Duration.millis(2000),
                24, 3,
                0, 0,
                118, 110
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public AnimalAnimation() {

    }
}

//TODO: 01/25/2019 fix for all PNGs, just working for cow:down.png now (need to set width and height of the images)
//TODO: 01/25/2019 fix down.png address