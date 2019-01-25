package src.GUI;


import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class AnimalAnimation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 400);
        //image in javafx
        Image animalImage = new Image(new FileInputStream("/Users/Ashkan/IdeaProjects/FramFrenzy/src/src/GUI/Textures/Cow/down.png")); // TODO: 01/25/2019 get correct address for animations
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
                64, 66
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
