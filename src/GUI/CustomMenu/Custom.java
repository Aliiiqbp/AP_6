package GUI.CustomMenu;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import GUI.GraphicHandler;

import static javafx.scene.text.FontWeight.BOLD;

public class Custom {
    public static void custom() {
        CustomMenu.customMenu();

        Label nameLable = new Label("Choose a name for your warehouse: ");
        nameLable.setLayoutX(100);
        nameLable.setLayoutY(150);
        nameLable.setTextFill(Color.WHITE);
        nameLable.setFont(Font.font("georgia", BOLD, 20));

        TextField nameInput = new TextField();
        nameInput.setLayoutX(500);
        nameInput.setLayoutY(150);

        Label inputLabel = new Label("Choose input product: ");
        inputLabel.setLayoutX(100);
        inputLabel.setLayoutY(200);
        inputLabel.setTextFill(Color.WHITE);
        inputLabel.setFont(Font.font("georgia", BOLD, 20));

        ChoiceBox<String> typeChoice = new ChoiceBox<>();
        typeChoice.getItems().addAll("Cake", "Egg");
        typeChoice.setLayoutX(500);
        typeChoice.setLayoutY(200);

        Label outputLabel = new Label("Number of fruits each time: ");
        outputLabel.setLayoutY(275);
        outputLabel.setLayoutX(100);
        outputLabel.setTextFill(Color.WHITE);
        outputLabel.setOpacity(0);

        TextField numberInput = new TextField();
        numberInput.setLayoutX(300);
        numberInput.setLayoutY(270);
        numberInput.setOpacity(0);
        numberInput.setDisable(true);

        Label timesLabel = new Label("Number of harvest times: ");
        timesLabel.setLayoutY(275);
        timesLabel.setLayoutX(100);
        timesLabel.setTextFill(Color.WHITE);
        timesLabel.setOpacity(0);

        TextField timesInput = new TextField();
        timesInput.setLayoutX(300);
        timesInput.setLayoutY(270);
        timesInput.setOpacity(0);
        timesInput.setDisable(true);

        Label healthLabel = new Label("Health addition:");
        healthLabel.setLayoutX(100);
        healthLabel.setLayoutY(350);
        healthLabel.setTextFill(Color.WHITE);
        healthLabel.setOpacity(0);

        TextField healthInput = new TextField();
        healthInput.setLayoutX(250);
        healthInput.setLayoutY(345);
        healthInput.setOpacity(0);
        healthInput.setDisable(true);

        Label maxHealthLabel = new Label("Max health addition:");
        maxHealthLabel.setLayoutX(100);
        maxHealthLabel.setLayoutY(400);
        maxHealthLabel.setTextFill(Color.WHITE);
        maxHealthLabel.setOpacity(0);

        TextField maxHealthInput = new TextField();
        maxHealthInput.setLayoutX(250);
        maxHealthInput.setLayoutY(395);
        maxHealthInput.setOpacity(0);
        maxHealthInput.setDisable(true);

        Label energyLabel = new Label("Energy addition:");
        energyLabel.setLayoutX(550);
        energyLabel.setLayoutY(350);
        energyLabel.setTextFill(Color.WHITE);
        energyLabel.setOpacity(0);

        TextField energyInput = new TextField();
        energyInput.setLayoutX(700);
        energyInput.setLayoutY(345);
        energyInput.setOpacity(0);
        energyInput.setDisable(true);

        Label maxEnergyLabel = new Label("Max energy addition:");
        maxEnergyLabel.setLayoutX(550);
        maxEnergyLabel.setLayoutY(400);
        maxEnergyLabel.setTextFill(Color.WHITE);
        maxEnergyLabel.setOpacity(0);

        TextField maxEnergyInput = new TextField();
        maxEnergyInput.setLayoutX(700);
        maxEnergyInput.setLayoutY(395);
        maxEnergyInput.setOpacity(0);
        maxEnergyInput.setDisable(true);

        Label staminaLabel = new Label("Stamina addition:");
        staminaLabel.setLayoutX(100);
        staminaLabel.setLayoutY(450);
        staminaLabel.setTextFill(Color.WHITE);
        staminaLabel.setOpacity(0);

        TextField staminaInput = new TextField();
        staminaInput.setLayoutX(250);
        staminaInput.setLayoutY(445);
        staminaInput.setOpacity(0);
        staminaInput.setDisable(true);

        Label maxStaminaLabel = new Label("Max stamina addition:");
        maxStaminaLabel.setLayoutX(100);
        maxStaminaLabel.setLayoutY(500);
        maxStaminaLabel.setTextFill(Color.WHITE);
        maxStaminaLabel.setOpacity(0);

        TextField maxStaminaInput = new TextField();
        maxStaminaInput.setLayoutX(250);
        maxStaminaInput.setLayoutY(495);
        maxStaminaInput.setOpacity(0);
        maxStaminaInput.setDisable(true);

        Label satietyLabel = new Label("Satiety addition:");
        satietyLabel.setLayoutX(550);
        satietyLabel.setLayoutY(450);
        satietyLabel.setTextFill(Color.WHITE);
        satietyLabel.setOpacity(0);

        TextField satietyInput = new TextField();
        satietyInput.setLayoutX(700);
        satietyInput.setLayoutY(445);
        satietyInput.setOpacity(0);
        satietyInput.setDisable(true);

        Label maxSatietyLabel = new Label("Max satiety addition:");
        maxSatietyLabel.setLayoutX(550);
        maxSatietyLabel.setLayoutY(500);
        maxSatietyLabel.setTextFill(Color.WHITE);
        maxSatietyLabel.setOpacity(0);

        TextField maxSatietyInput = new TextField();
        maxSatietyInput.setLayoutX(700);
        maxSatietyInput.setLayoutY(495);
        maxSatietyInput.setOpacity(0);
        maxSatietyInput.setDisable(true);

        typeChoice.setOnAction(event -> {
            if (typeChoice.getSelectionModel().getSelectedItem().equals("Tree")) {
                timesLabel.setOpacity(0);
                timesInput.setOpacity(0);
                timesInput.setDisable(true);
                outputLabel.setOpacity(1);
                numberInput.setOpacity(1);
                numberInput.setDisable(false);

                healthLabel.setOpacity(1);
                maxHealthLabel.setOpacity(1);
                energyLabel.setOpacity(1);
                maxEnergyLabel.setOpacity(1);
                staminaLabel.setOpacity(1);
                maxStaminaLabel.setOpacity(1);
                satietyLabel.setOpacity(1);
                maxSatietyLabel.setOpacity(1);

                healthInput.setOpacity(1);
                maxHealthInput.setOpacity(1);
                energyInput.setOpacity(1);
                maxEnergyInput.setOpacity(1);
                staminaInput.setOpacity(1);
                maxStaminaInput.setOpacity(1);
                satietyInput.setOpacity(1);
                maxSatietyInput.setOpacity(1);

                healthInput.setDisable(false);
                maxHealthInput.setDisable(false);
                energyInput.setDisable(false);
                maxEnergyInput.setDisable(false);
                staminaInput.setDisable(false);
                maxStaminaInput.setDisable(false);
                satietyInput.setDisable(false);
                maxSatietyInput.setDisable(false);
            } else {
                timesLabel.setOpacity(1);
                timesInput.setOpacity(1);
                timesInput.setDisable(false);
                outputLabel.setOpacity(0);
                numberInput.setOpacity(0);
                numberInput.setDisable(true);

                healthLabel.setOpacity(1);
                maxHealthLabel.setOpacity(1);
                energyLabel.setOpacity(1);
                maxEnergyLabel.setOpacity(1);
                staminaLabel.setOpacity(1);
                maxStaminaLabel.setOpacity(1);
                satietyLabel.setOpacity(1);
                maxSatietyLabel.setOpacity(1);

                healthInput.setOpacity(1);
                maxHealthInput.setOpacity(1);
                energyInput.setOpacity(1);
                maxEnergyInput.setOpacity(1);
                staminaInput.setOpacity(1);
                maxStaminaInput.setOpacity(1);
                satietyInput.setOpacity(1);
                maxSatietyInput.setOpacity(1);

                healthInput.setDisable(false);
                maxHealthInput.setDisable(false);
                energyInput.setDisable(false);
                maxEnergyInput.setDisable(false);
                staminaInput.setDisable(false);
                maxStaminaInput.setDisable(false);
                satietyInput.setDisable(false);
                maxSatietyInput.setDisable(false);
            }
        });

        CustomMenu.root.getChildren().addAll(nameLable, nameInput, inputLabel, typeChoice, outputLabel, numberInput, timesLabel, timesInput, healthLabel, healthInput, maxHealthLabel, maxHealthInput, energyLabel, energyInput, maxEnergyLabel, maxEnergyInput, staminaLabel, staminaInput, maxStaminaLabel, maxStaminaInput, satietyLabel, satietyInput, maxSatietyLabel, maxSatietyInput);

        GraphicHandler.game.setScene(CustomMenu.scene);
    }
}
