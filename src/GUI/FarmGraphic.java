package GUI;

import GUI.Menu.Menu;
import GUI.Menu.MenuItem;
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
import Controller.Controller;
import Controller.Static;
import Model.Farm.Farm;


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

        root.getChildren().addAll(statusBar, pauseButton);

        ///////////////////////buyHenIcon

        ImageView buyHenIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/hen.png"));
        buyHenIcon.setFitWidth(30);
        buyHenIcon.setFitHeight(30);
        buyHenIcon.setLayoutX(20);
        buyHenIcon.setLayoutY(15);

        Rectangle buyHenIconBack = new Rectangle(35, 15);
        buyHenIconBack.setLayoutY(47);
        buyHenIconBack.setLayoutX(17);
        buyHenIconBack.setFill(Color.WHITE);
        buyHenIconBack.setOpacity(0);
        Label buyHenIconLab = new Label(Integer.toString((int) Static.HEN_BUY_COST));
        buyHenIconLab.setFont(new Font("georgia", 14));
        buyHenIconLab.setLayoutY(46);
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

        root.getChildren().addAll(buyHenIcon, buyHenIconBack, buyHenIconLab);

        ///////////////////////////buySheepIcon

        ImageView buySheepIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/sheep.png"));
        buySheepIcon.setFitWidth(30);
        buySheepIcon.setFitHeight(30);
        buySheepIcon.setLayoutX(60);
        buySheepIcon.setLayoutY(15);

        Rectangle buySheepIconBack = new Rectangle(42, 15);
        buySheepIconBack.setLayoutY(47);
        buySheepIconBack.setLayoutX(57);
        buySheepIconBack.setFill(Color.WHITE);
        buySheepIconBack.setOpacity(0);
        Label buySheepIconLab = new Label(Integer.toString((int) Static.SHEEP_BUY_COST));
        buySheepIconLab.setFont(new Font("georgia", 14));
        buySheepIconLab.setLayoutY(46);
        buySheepIconLab.setLayoutX(62);
        buySheepIconLab.setOpacity(0);

        buySheepIcon.setOnMouseEntered(event -> {
            if (buySheepIcon.getOpacity() >= 0.8) {
                buySheepIconBack.setFill(Color.BLACK);
                buySheepIconLab.setTextFill(Color.WHITE);
                fadeMainMenu(buySheepIconBack, buySheepIconBack.getOpacity(), 0.7, 500).play();
                fadeMainMenu(buySheepIconLab, buySheepIconLab.getOpacity(), 1, 500).play();
            }
        });

        buySheepIcon.setOnMouseExited(event -> {
            fadeMainMenu(buySheepIconBack, buySheepIconBack.getOpacity(), 0, 500).play();
            fadeMainMenu(buySheepIconLab, buySheepIconLab.getOpacity(), 0, 500).play();
        });

        buySheepIcon.setOnMouseClicked(event -> {
            // TODO: buy Sheep
        });

        root.getChildren().addAll(buySheepIcon, buySheepIconBack, buySheepIconLab);

        ////////////////////////////////////////buyCowIcon

        ImageView buyCowIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/cow.png"));
        buyCowIcon.setFitWidth(30);
        buyCowIcon.setFitHeight(30);
        buyCowIcon.setLayoutX(100);
        buyCowIcon.setLayoutY(15);

        Rectangle buyCowIconBack = new Rectangle(50, 15);
        buyCowIconBack.setLayoutY(47);
        buyCowIconBack.setLayoutX(92);
        buyCowIconBack.setFill(Color.WHITE);
        buyCowIconBack.setOpacity(0);
        Label buyCowIconLab = new Label(Integer.toString((int) Static.COW_BUY_COST));
        buyCowIconLab.setFont(new Font("georgia", 14));
        buyCowIconLab.setLayoutY(46);
        buyCowIconLab.setLayoutX(97);
        buyCowIconLab.setOpacity(0);

        buyCowIcon.setOnMouseEntered(event -> {
            if (buyCowIcon.getOpacity() >= 0.8) {
                buyCowIconBack.setFill(Color.BLACK);
                buyCowIconLab.setTextFill(Color.WHITE);
                fadeMainMenu(buyCowIconBack, buyCowIconBack.getOpacity(), 0.7, 500).play();
                fadeMainMenu(buyCowIconLab, buyCowIconLab.getOpacity(), 1, 500).play();
            }
        });

        buyCowIcon.setOnMouseExited(event -> {
            fadeMainMenu(buyCowIconBack, buyCowIconBack.getOpacity(), 0, 500).play();
            fadeMainMenu(buyCowIconLab, buyCowIconLab.getOpacity(), 0, 500).play();
        });

        buyCowIcon.setOnMouseClicked(event -> {
            // TODO: buy Cow
        });

        root.getChildren().addAll(buyCowIcon, buyCowIconBack, buyCowIconLab);
        
        /////////////////////////////////////////buyCatIcon
        
        ImageView buyCatIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/cat.png"));
        buyCatIcon.setFitWidth(30);
        buyCatIcon.setFitHeight(30);
        buyCatIcon.setLayoutX(140);
        buyCatIcon.setLayoutY(15);

        Rectangle buyCatIconBack = new Rectangle(41, 15);
        buyCatIconBack.setLayoutY(47);
        buyCatIconBack.setLayoutX(137);
        buyCatIconBack.setFill(Color.WHITE);
        buyCatIconBack.setOpacity(0);
        Label buyCatIconLab = new Label(Integer.toString((int) Static.CAT_BUY_COST));
        buyCatIconLab.setFont(new Font("georgia", 14));
        buyCatIconLab.setLayoutY(46);
        buyCatIconLab.setLayoutX(142);
        buyCatIconLab.setOpacity(0);

        buyCatIcon.setOnMouseEntered(event -> {
            if (buyCatIcon.getOpacity() >= 0.8) {
                buyCatIconBack.setFill(Color.BLACK);
                buyCatIconLab.setTextFill(Color.WHITE);
                fadeMainMenu(buyCatIconBack, buyCatIconBack.getOpacity(), 0.7, 500).play();
                fadeMainMenu(buyCatIconLab, buyCatIconLab.getOpacity(), 1, 500).play();
            }
        });

        buyCatIcon.setOnMouseExited(event -> {
            fadeMainMenu(buyCatIconBack, buyCatIconBack.getOpacity(), 0, 500).play();
            fadeMainMenu(buyCatIconLab, buyCatIconLab.getOpacity(), 0, 500).play();
        });

        buyCatIcon.setOnMouseClicked(event -> {
            // TODO: buy Cat
        });

        root.getChildren().addAll(buyCatIcon, buyCatIconBack, buyCatIconLab);
        
        ////////////////////////////////////////////buyDogIcon
        
        ImageView buyDogIcon = new ImageView(new Image("src/Resources/Textures/UI/Icons/dog.png"));
        buyDogIcon.setFitWidth(30);
        buyDogIcon.setFitHeight(30);
        buyDogIcon.setLayoutX(180);
        buyDogIcon.setLayoutY(15);

        Rectangle buyDogIconBack = new Rectangle(43, 15);
        buyDogIconBack.setLayoutY(47);
        buyDogIconBack.setLayoutX(179);
        buyDogIconBack.setFill(Color.WHITE);
        buyDogIconBack.setOpacity(0);
        Label buyDogIconLab = new Label(Integer.toString((int) Static.DOG_BUY_COST));
        buyDogIconLab.setFont(new Font("georgia", 14));
        buyDogIconLab.setLayoutY(46);
        buyDogIconLab.setLayoutX(184);
        buyDogIconLab.setOpacity(0);

        buyDogIcon.setOnMouseEntered(event -> {
            if (buyDogIcon.getOpacity() >= 0.8) {
                buyDogIconBack.setFill(Color.BLACK);
                buyDogIconLab.setTextFill(Color.WHITE);
                fadeMainMenu(buyDogIconBack, buyDogIconBack.getOpacity(), 0.7, 500).play();
                fadeMainMenu(buyDogIconLab, buyDogIconLab.getOpacity(), 1, 500).play();
            }
        });

        buyDogIcon.setOnMouseExited(event -> {
            fadeMainMenu(buyDogIconBack, buyDogIconBack.getOpacity(), 0, 500).play();
            fadeMainMenu(buyDogIconLab, buyDogIconLab.getOpacity(), 0, 500).play();
        });

        buyDogIcon.setOnMouseClicked(event -> {
            // TODO: buy Dog
        });

        root.getChildren().addAll(buyDogIcon, buyDogIconBack, buyDogIconLab);

        ////////////////////////////////////////////

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