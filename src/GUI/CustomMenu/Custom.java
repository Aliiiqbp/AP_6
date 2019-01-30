package src.GUI.CustomMenu;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import src.GUI.GraphicHandler;
import java.awt.*;

import static javafx.scene.text.FontWeight.BOLD;

public class Custom {
    public static void custom() {
        CustomMenu.customMenu();

        Label nameLable = new Label("Choose a name for your warehouse: ");
        nameLable.setLayoutX(200);
        nameLable.setLayoutY(150);
        nameLable.setTextFill(Color.WHITE);
        nameLable.setFont(Font.font("georgia", BOLD, 20));

        TextField nameInput = new TextField();
        nameInput.setLayoutX(600);
        nameInput.setLayoutY(150);

        Label inputLabel = new Label("Choose input product: ");
        inputLabel.setLayoutX(50);
        inputLabel.setLayoutY(200);
        inputLabel.setTextFill(Color.WHITE);
        inputLabel.setFont(Font.font("georgia", BOLD, 20));

        ChoiceBox<String> inputChoice = new ChoiceBox<>();
        inputChoice.getItems().addAll("Cake", "Carnival Dress", "Cookie", "Egg", "Egg Powder", "Fabric", "Flour", "Milk", "Plume", "Sewing", "Wool");
        inputChoice.setLayoutX(300);
        inputChoice.setLayoutY(200);

        Label outputLabel = new Label("Choose output product: ");
        outputLabel.setLayoutX(500);
        outputLabel.setLayoutY(200);
        outputLabel.setTextFill(Color.WHITE);
        outputLabel.setFont(Font.font("georgia", BOLD, 20));

        ChoiceBox<String> outputChoice = new ChoiceBox<>();
        outputChoice.getItems().addAll("Cake", "Carnival Dress", "Cookie", "Egg", "Egg Powder", "Fabric", "Flour", "Milk", "Plume", "Sewing", "Wool");
        outputChoice.setLayoutX(750);
        outputChoice.setLayoutY(200);

        CustomMenu.root.getChildren().addAll(nameLable, nameInput, inputLabel, inputChoice, outputLabel, outputChoice);

        GraphicHandler.game.setScene(CustomMenu.scene);
    }
}
