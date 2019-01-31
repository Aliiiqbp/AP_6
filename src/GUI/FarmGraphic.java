package src.GUI;

import javafx.scene.control.*;
import src.GUI.Menu.Menu;
import src.GUI.Menu.MenuItem;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import src.Controller.Controller;
import src.Controller.Static;
import src.Model.Animal.AnimalType;
import src.Model.Farm.Bank;
import src.Model.Farm.Farm;
import src.Network.Chat.ClientGUI;
import src.Network.Chat.SingleMessage;
import src.Network.Chat.Status;
import src.Network.Network;

import java.io.FileReader;
import java.util.ArrayList;


public class FarmGraphic {
    private static Group root;
    private static Timeline interact;
    private static Menu pauseMenu;
    private static Menu activeMenu = null;
    public static TextArea textArea = new TextArea();
    public static TextField textField = new TextField();
    public static Bank bank;

    public static void farmScene(String where) {
        ImageView background = new ImageView(new Image("src/Resources/Textures/back.png"));

        root = new Group(background);

        Farm farm = new Farm();
        Controller controller = new Controller(farm);
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
            controller.buyAnimal(AnimalType.HEN, Math.random() * 700 + 50, Math.random() * 500 + 50);
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
            controller.buyAnimal(AnimalType.SHEEP, Math.random() * 700 + 50, Math.random() * 500 + 50);
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
            controller.buyAnimal(AnimalType.COW, Math.random() * 700 + 50, Math.random() * 500 + 50);
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
            controller.buyAnimal(AnimalType.CAT, Math.random() * 700 + 50, Math.random() * 500 + 50);
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
            controller.buyAnimal(AnimalType.DOG, Math.random() * 700 + 50, Math.random() * 500 + 50);
        });

        root.getChildren().addAll(buyDogIcon, buyDogIconBack, buyDogIconLab);

        ////////////////////////////////////////////


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
                long nowInt = now / (2 * constant);
                if (nowInt > beforeInt) {
                    beforeInt = nowInt;
                    System.out.println("A second Passed");
                    // Every second will update locations
                    controller.updateLocation(root);
                }
            }
        };
        timer.start();

        if (GraphicHandler.isOnline) {
            addOnlineButtons();
            System.out.println("addOnlineButtons");
        }

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


    /////////////////////////////////////////

    public static Rectangle other = new Rectangle(64, 64, Color.WHITE);

    private static boolean isOnPublicChatWindow = false;
    private static boolean isOnChatSelectWindow = false;
    private static boolean isOnStatusWindow = false;

    public static TextArea textArea1 = new TextArea();
    public static TextField textField1 = new TextField();
    private static ListView<String> chatList = new ListView<>();
    private static Button sendChatRequest = new Button("Send Request");
    private static Button getPlayerStatus = new Button("Get Status");

    //private final static int TIME_RATE = 100;
    public static void addOnlineButtons() {
        sendChatRequest.setMinSize(440, 50);
        sendChatRequest.setLayoutX(800);
        sendChatRequest.setLayoutY(600 - 50);
        sendChatRequest.setOnMouseClicked(event -> {
            if (chatList.getSelectionModel().getSelectedItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("You have to choose a member to start chat.");
                alert.show();
            } else {
                String to = chatList.getSelectionModel().getSelectedItem();
                String from = Network.clientString;
                SingleMessage singleMessage = new SingleMessage(from, to, false);
                ClientGUI.sendSingleMessage(singleMessage);
            }
        });

        getPlayerStatus.setMinSize(440, 50);
        getPlayerStatus.setLayoutX(800);
        getPlayerStatus.setLayoutY(600 - 50);
        getPlayerStatus.setOnMouseClicked(event -> {
            if (chatList.getSelectionModel().getSelectedItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("You have to choose a member to see status.");
                alert.show();
            } else {
                Status status = new Status(Network.clientString, (int) bank.getMoney());

            }
        });

        other.setOpacity(0);
        other.setLayoutX(500);
        other.setLayoutY(650);

        chatList.setLayoutX(800);
        chatList.setMinWidth(440);
        chatList.setMinHeight(600);

        textArea1.setLayoutX(800);
        textArea1.setMinWidth(440);
        textArea1.setMinHeight(600 - 50);
        textArea1.setEditable(false);

        textField1.setLayoutX(800);
        textField1.setLayoutY(550);
        textField1.setMinWidth(440);
        textField1.setMinHeight(50);

        ImageView groupChat = new ImageView(new Image("src/Resources/Online/groupChat.png"));
        groupChat.setFitWidth(30);
        groupChat.setFitHeight(30);
        groupChat.setLayoutX(700);
        groupChat.setLayoutY(15);
        groupChat.setOnMouseClicked(event -> {
            if (isOnPublicChatWindow) {
                GraphicHandler.game.setWidth(800);
                GraphicHandler.game.setX(GraphicHandler.game.getX() + 220);
                root.getChildren().removeAll(textArea1, textField1);
            } else {
                GraphicHandler.game.setWidth(1240);
                GraphicHandler.game.setX(GraphicHandler.game.getX() - 220);
                root.getChildren().addAll(textArea1, textField1);
            }
            isOnPublicChatWindow = !isOnPublicChatWindow;
        });

        ImageView chat = new ImageView(new Image("src/Resources/Online/chat.png"));
        chat.setFitWidth(35);
        chat.setFitHeight(35);
        chat.setLayoutY(550);
        chat.setLayoutX(600);
        chat.setOnMouseClicked(event -> {
            if (isOnChatSelectWindow) {
                GraphicHandler.game.setWidth(800);
                GraphicHandler.game.setX(GraphicHandler.game.getX() + 220);
                root.getChildren().removeAll(chatList, sendChatRequest);
            } else {
                for (String string : getNames()) {
                    if (!chatList.getItems().contains(string)) {
                        chatList.getItems().add(string);
                    }
                }
                GraphicHandler.game.setWidth(1240);
                GraphicHandler.game.setX(GraphicHandler.game.getX() - 220);
                root.getChildren().addAll(chatList, sendChatRequest);
            }
            isOnChatSelectWindow = !isOnChatSelectWindow;
        });

        ImageView friend = new ImageView(new Image("src/Resources/Online/friends.png"));
        friend.setFitWidth(35);
        friend.setFitHeight(35);
        friend.setLayoutY(550);
        friend.setLayoutX(650);
        friend.setOnMouseClicked(event -> {

        });

        ImageView trade = new ImageView(new Image("src/Resources/Online/trade.png"));
        trade.setFitWidth(35);
        trade.setFitHeight(35);
        trade.setLayoutY(550);
        trade.setLayoutX(700);

        ImageView status = new ImageView(new Image("src/Resources/Online/status.png"));
        status.setFitWidth(35);
        status.setFitHeight(35);
        status.setLayoutY(550);
        status.setLayoutX(750);
        status.setOnMouseClicked(event -> {
            if (isOnStatusWindow) {
                GraphicHandler.game.setWidth(800);
                root.getChildren().removeAll(chatList, getPlayerStatus);
                GraphicHandler.game.setX(GraphicHandler.game.getX() + 220);
            } else {
                for (String string : getNames()) {
                    if (!chatList.getItems().contains(string)) {
                        chatList.getItems().add(string);
                    }
                }
                GraphicHandler.game.setWidth(1240);
                root.getChildren().addAll(chatList, getPlayerStatus);
                GraphicHandler.game.setX(GraphicHandler.game.getX() - 220);
            }
            isOnStatusWindow = !isOnStatusWindow;
        });

        root.getChildren().addAll(chat, friend, trade, status, groupChat);
    }

    private static ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            FileReader namesToChat = new FileReader("src/src/Resources/Network/serverInfo/" + Network.serverString + "/info.txt");
            StringBuilder result = new StringBuilder();
            int ascii = namesToChat.read();
            while (ascii != -1) {
                result.append((char) ascii);
                ascii = namesToChat.read();
            }
            String[] servers = result.toString().split("\n");
            for (String string : servers) {
                if (!string.equals(Network.clientString)) {
                    names.add(string);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}