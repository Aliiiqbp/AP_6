package src.GUI.CustomMenu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.GUI.GraphicHandler;

public class CustomMenu {
    protected static Group root;
    protected static Scene scene;

    protected static void customMenu() {
        root = new Group();
        scene = new Scene(root, 960, 712.5);

        ImageView background = new ImageView(new Image("src/Resources/Custom/Leaf.jpg"));
        background.setFitWidth(960);
        background.setFitHeight(713);

        ImageView back = new ImageView(new Image("src/Resources/Server/back.png"));
        back.setFitWidth(80);
        back.setFitHeight(80);
        back.setLayoutX(20);
        back.setLayoutY(613);

        back.setOnMouseClicked(event -> GraphicHandler.game.setScene(GraphicHandler.mainMenu()));

        root.getChildren().addAll(background, back);
    }
}
