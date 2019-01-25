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
        Image boyImage = new Image(new FileInputStream("boys.png")); // TODO: 01/25/2019 get correct address for animations
        ImageView boyView = new ImageView(boyImage);
        boyView.setX(20);
        boyView.setY(20);

        root.getChildren().add(boyView);

        boyView.setViewport(new Rectangle2D(0, 0, 829, 66));
//sprite animation  useful for your project
        final Animation animation = new AnimalSpriteAnimation(
                boyView,
                Duration.millis(2000),
                13, 13,
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
