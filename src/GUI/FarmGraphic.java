package src.GUI;

//import graphic.Handle.Group;
//import graphic.Handle.Graphic_Handler;
//import graphic.Handle.environment.farm.home.Home_Graphic;
//import graphic.Handle.environment.jungle.Jungle_Graphic;
//import graphic.Handle.environment.village.Village_Graphic;
//import graphic.Handle.farmer.Farmer_Graphic;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import src.Controller.Controller;
import src.Controller.Static;
import src.Model.Animal.Pet.NoneProducer.Dog;
import src.Model.Coordinate.Direction;
import src.GUI.Menu.*;
import src.Model.Farm.Farm;


public class FarmGraphic {
    private static Group root;
    private static Timeline interact;
    private static Menu pauseMenu;
    private static Menu activeMenu = null;

    public static void farmScene(String where) {
        ImageView background = new ImageView(new Image("src/Resources/Textures/back.png"));

        root = new Group(background);
        ////////////////////////Status bar

        Rectangle statusBar = new Rectangle(780, 40);
        statusBar.setFill(Color.WHITE);
        statusBar.setOpacity(0.5);
        statusBar.setLayoutX(10);
        statusBar.setLayoutY(10);
        statusBar.setArcWidth(40);
        statusBar.setArcHeight(40);

        ///////////////////////pauseButton and pauseMenu

        ImageView pauseButton = new ImageView(new Image("src/Resources/Menu/pause.png"));
        pauseButton.setFitWidth(30);
        pauseButton.setFitHeight(30);
        pauseButton.setLayoutX(755);
        pauseButton.setLayoutY(15);

        pauseMenu = new Menu("Pause", root);
        pauseMenu.getMenuItem(0).setText("Continue");
//        Menu otherMenu = new Menu("Test", root, pauseMenu);
//        otherMenu.addAll(new MenuItem("one", otherMenu));
//        MenuItem backpack = new MenuItem("Show The Backpack", pauseMenu);
//        MenuItem status = new MenuItem("Show Status", pauseMenu);
        MenuItem quit = new MenuItem("Quit to Main Menu", pauseMenu);
//        status.setGoesTo(otherMenu);
        quit.setGoesTo(() -> GraphicHandler.game.setScene(GraphicHandler.mainMenu()));
        pauseMenu.addAll(/*backpack, status,*/quit);

        pauseButton.setOnMouseClicked(event -> {
//            if (!root.getChildren().contains(pauseMenu)) {
////                pauseMenu.start();
//                if (Menu.parent != null)
//                    Menu.parent.exit();
//                else
//                    FarmGraphic.Pause(this);
//                if (root != null) {
//                    root.getChildren().add(menuFrame);
//                    if (menuSize() > 0)
//                        getMenuItem(current).requestFocus();
//                    getRoot().setActiveMenu(this);
//                }
//
//            }
        });

        ///////////////////////buyHenIcon

        ImageView buyHenIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/hen.png"));
        buyHenIcon.setFitWidth(30);
        buyHenIcon.setFitHeight(30);
        buyHenIcon.setLayoutX(20);
        buyHenIcon.setLayoutY(15);

        Rectangle buyHenIconBack = new Rectangle(40, 15);
        buyHenIconBack.setLayoutY(45);
        buyHenIconBack.setLayoutX(17);
        buyHenIconBack.setFill(Color.WHITE);
        buyHenIconBack.setOpacity(0);
        Label buyHenIconLab = new Label(Integer.toString((int) Static.HEN_BUY_COST));
        buyHenIconLab.setFont(new Font("Atlas of the Magi", 14));
        buyHenIconLab.setLayoutY(44);
        buyHenIconLab.setLayoutX(22);
        buyHenIconLab.setOpacity(0);

        buyHenIcon.setOnMouseEntered(event -> {
            if (buyHenIcon.getOpacity() >= 0.8) {
                buyHenIconBack.setFill(Color.BLACK);
                buyHenIconLab.setTextFill(Color.WHITE);
                fadeMainMenu(buyHenIconBack, buyHenIconBack.getOpacity(), 0.7, 500).play();
                fadeMainMenu(buyHenIconLab, buyHenIconLab.getOpacity(), 1, 500).play();
            }
        });

        buyHenIcon.setOnMouseExited(event -> {
            fadeMainMenu(buyHenIconBack, buyHenIconBack.getOpacity(), 0, 500).play();
            fadeMainMenu(buyHenIconLab, buyHenIconLab.getOpacity(), 0, 500).play();
        });

        buyHenIcon.setOnMouseClicked(event -> {
            // TODO: buy Hen
        });
        ///////////////////////////


        root.getChildren().addAll(statusBar, pauseButton, buyHenIcon, buyHenIconBack, buyHenIconLab);

        //////////////////////////////////////



        Farm farm = new Farm();
        Controller controller = new Controller(farm);

        controller.initializeGame();
        //it initializes Game, some dogs and cats are generated in farm

        ////////////////starting to handle the time

        //   final int[] tooShow = {100};
    //    tooShow[0] = 10;
        AnimationTimer timer = new AnimationTimer() {
            final long constant = 1000000000;
            long beforeInt = 0;
            @Override
            public void handle(long now) {
                long nowInt = now / constant;
                if (nowInt > beforeInt){
                    beforeInt = nowInt;
                    System.out.println("A second Passed");
                    // Every second will update locations
                    controller.updateLocation(root);
                }
            }
        };
        timer.start();



        Scene scene = new Scene(root, 800, 600);
        GraphicHandler.game.setScene(scene);


    }

    public static FadeTransition fadeMainMenu(Node node, double from, double to, int duration) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration));
        fadeTransition.setNode(node);
        fadeTransition.setCycleCount(1);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.setAutoReverse(false);
        return fadeTransition;
    }

    public boolean isActive() {
        return activeMenu == null;
    }

    public void setActiveMenu(Menu menu) {
        activeMenu = menu;
    }

    public void Pause(Menu menu) {
        if (isActive()) {
//            Farmer_Graphic.move.pause();
            activeMenu = menu;
        }
    }

    public void Play() {
        if (!isActive()) {
//            Farmer_Graphic.move.play();
            activeMenu = null;
//            requestFocus();
        }
    }
}