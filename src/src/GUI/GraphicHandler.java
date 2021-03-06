package src.GUI;

import src.GUI.FarmGraphic;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.GUI.CustomMenu.Custom;
import src.Network.Network;

import java.io.File;
import java.time.LocalTime;
import java.util.Optional;

//import network.Network;

public class GraphicHandler extends Application {
    public static boolean isOnline = false;

    public static Group sceneRoot;
    public static Group root;
    public static Stage game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        game = primaryStage;
        primaryStage.setScene(mainMenu());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static Scene mainMenu() {
        LocalTime now = LocalTime.now();

        root = new Group();
        Scene scene = new Scene(root, 960, 712.5);

        Label logo = new Label("MYSTIC FARM");
        Label anyKey = new Label("Click to continue");
        logo.setFont(new Font("Snickles", 70));
        anyKey.setFont(new Font("Atlas of the Magi", 20));

        Rectangle logoBack = new Rectangle(300, 70);
        Rectangle anyBack = new Rectangle(300, 25);
        logoBack.setFill(Color.WHITE);
        anyBack.setFill(Color.WHITE);
        logoBack.setOpacity(0.7);
        logoBack.setArcWidth(50);
        logoBack.setArcHeight(50);
        anyBack.setOpacity(0.7);
        anyBack.setArcHeight(20);
        anyBack.setArcWidth(20);

        Rectangle singleBack = new Rectangle(120, 15);
        singleBack.setLayoutY(450);
        singleBack.setLayoutX(40);
        singleBack.setFill(Color.WHITE);
        singleBack.setOpacity(0);
        Label singleLab = new Label("Single Player");
        singleLab.setFont(new Font("Death Star", 14));
        singleLab.setLayoutY(449);
        singleLab.setLayoutX(50);
        singleLab.setOpacity(0);

        Rectangle multiBack = new Rectangle(120, 15);
        multiBack.setLayoutY(450);
        multiBack.setLayoutX(230);
        multiBack.setFill(Color.WHITE);
        multiBack.setOpacity(0);
        Label multiLab = new Label("Multi Player");
        multiLab.setFont(new Font("Death Star", 14));
        multiLab.setLayoutY(449);
        multiLab.setLayoutX(240);
        multiLab.setOpacity(0);

        Rectangle customBack = new Rectangle(120, 15);
        customBack.setLayoutY(450);
        customBack.setLayoutX(420);
        customBack.setFill(Color.WHITE);
        customBack.setOpacity(0);
        Label customLab = new Label("Custom Game");
        customLab.setFont(new Font("Death Star", 14));
        customLab.setLayoutY(449);
        customLab.setLayoutX(430);
        customLab.setOpacity(0);

        Rectangle setBack = new Rectangle(120, 15);
        setBack.setLayoutY(450);
        setBack.setLayoutX(615);
        setBack.setFill(Color.WHITE);
        setBack.setOpacity(0);
        Label setLab = new Label("Settings");
        setLab.setFont(new Font("Death Star", 14));
        setLab.setLayoutY(449);
        setLab.setLayoutX(645);
        setLab.setOpacity(0);

        Rectangle exitBack = new Rectangle(120, 15);
        exitBack.setLayoutY(450);
        exitBack.setLayoutX(800);
        exitBack.setFill(Color.WHITE);
        exitBack.setOpacity(0);
        Label exitLab = new Label("Exit");
        exitLab.setFont(new Font("Death Star", 14));
        exitLab.setLayoutY(449);
        exitLab.setLayoutX(845);
        exitLab.setOpacity(0);

        MediaPlayer MainMusic = new MediaPlayer(new Media(new File("src/Resources/Music/MammadNobari.mp3").toURI().toString()));
//        MediaPlayer MammadNobari = new MediaPlayer(new Media(new File("src/Resources/Music/MammadNobari.mp3").toURI().toString()));
        MainMusic.setVolume(0.4);
//        MammadNobari.setVolume(0.2);
        MainMusic.setCycleCount(MediaPlayer.INDEFINITE);
//        MammadNobari.setCycleCount(MediaPlayer.INDEFINITE);
        MainMusic.play();
//        MammadNobari.play();

        ImageView background = new ImageView();
        ImageView toggle = new ImageView();
        ImageView voice = new ImageView();
        ImageView singleImage = new ImageView(new Image("src/Resources/Menu/singlePlayer.png"));
        ImageView multiImage = new ImageView(new Image("src/Resources/Menu/multiPlayer.png"));
        ImageView customImage = new ImageView(new Image("src/Resources/Menu/custom.png"));
        ImageView settingImage = new ImageView(new Image("src/Resources/Menu/settings.png"));
        ImageView exitImage = new ImageView(new Image("src/Resources/Menu/exit.png"));

        Image day = new Image("src/Resources/Menu/main_menu_day.gif");
        Image night = new Image("src/Resources/Menu/main_menu_night.gif");
        Image dayButton = new Image("src/Resources/Menu/day_icon.png");
        Image nightButton = new Image("src/Resources/Menu/night_icon.png");
        Image play = new Image("src/Resources/Menu/play.png");
        Image mute = new Image("src/Resources/Menu/mute.png");
        voice.setImage(play);

        Button shiftTime = new Button();
        Button sound = new Button();

        Button single = new Button();
        singleImage.setFitWidth(100);
        singleImage.setFitHeight(100);
        single.setGraphic(singleImage);
        single.setStyle("-fx-background-color: #30cf85;");
        single.setDisable(true);
        single.setOpacity(0);
        single.setLayoutX(25);
        single.setLayoutY(290);

        Button multi = new Button();
        multiImage.setFitWidth(100);
        multiImage.setFitHeight(100);
        multi.setGraphic(multiImage);
        multi.setStyle("-fx-background-color: #ffaa00;");
        multi.setDisable(true);
        multi.setOpacity(0);
        multi.setLayoutX(215);
        multi.setLayoutY(290);

        Button custom = new Button();
        customImage.setFitWidth(100);
        customImage.setFitHeight(100);
        custom.setGraphic(customImage);
        custom.setStyle("-fx-background-color: #cf3080;");
        custom.setDisable(true);
        custom.setOpacity(0);
        custom.setLayoutX(405);
        custom.setLayoutY(290);

        Button setting = new Button();
        settingImage.setFitWidth(100);
        settingImage.setFitHeight(100);
        setting.setGraphic(settingImage);
        setting.setStyle("-fx-background-color: #f44336;");
        setting.setDisable(true);
        setting.setOpacity(0);
        setting.setLayoutX(595);
        setting.setLayoutY(290);

        Button exit = new Button();
        exitImage.setFitWidth(100);
        exitImage.setFitHeight(100);
        exit.setGraphic(exitImage);
        exit.setStyle("-fx-background-color: #01ced5;");
        exit.setDisable(true);
        exit.setOpacity(0);
        exit.setLayoutX(785);
        exit.setLayoutY(290);

        toggle.setFitHeight(50);
        toggle.setFitWidth(50);
        voice.setFitWidth(40);
        voice.setFitHeight(40);
        background.setFitWidth(960);
        background.setFitHeight(713);
        shiftTime.setLayoutX(920);
        shiftTime.setLayoutY(670);
        sound.setLayoutX(40);
        sound.setLayoutY(675);
        logo.setLayoutX(350);
        logo.setLayoutY(270);
        anyKey.setLayoutX(363);
        anyKey.setLayoutY(360);
        logoBack.setLayoutX(335);
        logoBack.setLayoutY(275);
        anyBack.setLayoutX(335);
        anyBack.setLayoutY(360);

        sound.setGraphic(voice);

        if (now.getHour() >= 20 || now.getHour() <= 5) {
            logo.setTextFill(Color.BLACK);
            anyKey.setTextFill(Color.BLACK);
            logoBack.setFill(Color.WHITE);
            anyBack.setFill(Color.WHITE);
            toggle.setImage(dayButton);
            background.setImage(night);
            shiftTime.setGraphic(toggle);
        } else {
            logo.setTextFill(Color.WHITE);
            anyKey.setTextFill(Color.WHITE);
            logoBack.setFill(Color.BLACK);
            anyBack.setFill(Color.BLACK);
            toggle.setImage(nightButton);
            background.setImage(day);
            shiftTime.setGraphic(toggle);
        }

        shiftTime.setOnAction(event -> {
            if (background.getImage().equals(day)) {
                background.setImage(night);
                toggle.setImage(dayButton);
                shiftTime.setGraphic(toggle);
                logo.setTextFill(Color.BLACK);
                anyKey.setTextFill(Color.BLACK);
                logoBack.setFill(Color.WHITE);
                anyBack.setFill(Color.WHITE);
            } else {
                toggle.setImage(nightButton);
                background.setImage(day);
                shiftTime.setGraphic(toggle);
                logo.setTextFill(Color.WHITE);
                anyKey.setTextFill(Color.WHITE);
                logoBack.setFill(Color.BLACK);
                anyBack.setFill(Color.BLACK);
            }
        });

        sound.setOnAction(event -> {
            if (voice.getImage().equals(play)) {
                voice.setImage(mute);
                MainMusic.pause();
                MainMusic.pause();
            } else {
                voice.setImage(play);
                MainMusic.play();
                MainMusic.play();
            }
        });

        single.setOnMouseEntered(event -> {
            if (single.getOpacity() >= 0.8) {
                if (background.getImage().equals(day)) {
                    singleBack.setFill(Color.BLACK);
                    singleLab.setTextFill(Color.WHITE);
                    fadeMainMenu(singleBack, singleBack.getOpacity(), 0.7, 500).play();
                    fadeMainMenu(singleLab, singleLab.getOpacity(), 1, 500).play();
                } else {
                    singleBack.setFill(Color.WHITE);
                    singleLab.setTextFill(Color.BLACK);
                    fadeMainMenu(singleBack, singleBack.getOpacity(), 0.7, 500).play();
                    fadeMainMenu(singleLab, singleLab.getOpacity(), 1, 500).play();
                }
            }
        });

        single.setOnMouseExited(event -> {
            fadeMainMenu(singleBack, singleBack.getOpacity(), 0, 500).play();
            fadeMainMenu(singleLab, singleLab.getOpacity(), 0, 500).play();
        });

        single.setOnMouseClicked(event -> {
            MainMusic.stop();
            //            MammadNobari.stop();
            isOnline = false;
            FarmGraphic.farmScene("start");
        });

        multi.setOnMouseEntered(event -> {
            if (multi.getOpacity() >= 0.8) {
                if (background.getImage().equals(day)) {
                    multiBack.setFill(Color.BLACK);
                    multiLab.setTextFill(Color.WHITE);
                    fadeMainMenu(multiBack, multiBack.getOpacity(), 0.7, 500).play();
                    fadeMainMenu(multiLab, multiLab.getOpacity(), 1, 500).play();
                } else {
                    multiBack.setFill(Color.WHITE);
                    multiLab.setTextFill(Color.BLACK);
                    fadeMainMenu(multiLab, multiLab.getOpacity(), 1, 500).play();
                    fadeMainMenu(multiBack, multiBack.getOpacity(), 0.7, 500).play();
                }
            }
        });

        multi.setOnMouseExited(event -> {
            fadeMainMenu(multiBack, multiBack.getOpacity(), 0, 500).play();
            fadeMainMenu(multiLab, multiLab.getOpacity(), 0, 500).play();
        });

        multi.setOnMouseClicked(event -> {
            if (multi.getOpacity() >= 0.8) {
//                MammadNobari.stop();
                MainMusic.stop();
                Network.networkScene();
            }
        });

        custom.setOnMouseEntered(event -> {
            if (custom.getOpacity() >= 0.8) {
                if (background.getImage().equals(day)) {
                    customBack.setFill(Color.BLACK);
                    customLab.setTextFill(Color.WHITE);
                    fadeMainMenu(customLab, customLab.getOpacity(), 1, 500).play();
                    fadeMainMenu(customBack, customBack.getOpacity(), 0.7, 500).play();
                } else {
                    customBack.setFill(Color.WHITE);
                    customLab.setTextFill(Color.BLACK);
                    fadeMainMenu(customBack, customBack.getOpacity(), 0.7, 500).play();
                    fadeMainMenu(customLab, customLab.getOpacity(), 1, 500).play();
                }
            }
        });

        custom.setOnMouseExited(event -> {
            fadeMainMenu(customBack, customBack.getOpacity(), 0, 500).play();
            fadeMainMenu(customLab, customLab.getOpacity(), 0, 500).play();
        });

        custom.setOnMouseClicked(event -> Custom.custom());

        setting.setOnMouseEntered(event -> {
            if (setting.getOpacity() >= 0.8) {
                if (background.getImage().equals(day)) {
                    setBack.setFill(Color.BLACK);
                    setLab.setTextFill(Color.WHITE);
                    fadeMainMenu(setLab, setLab.getOpacity(), 1, 500).play();
                    fadeMainMenu(setBack, setBack.getOpacity(), 0.7, 500).play();
                } else {
                    setBack.setFill(Color.WHITE);
                    setLab.setTextFill(Color.BLACK);
                    fadeMainMenu(setLab, setLab.getOpacity(), 1, 500).play();
                    fadeMainMenu(setBack, setBack.getOpacity(), 0.7, 500).play();
                }
            }
        });

        setting.setOnMouseExited(event -> {
            fadeMainMenu(setBack, setBack.getOpacity(), 0, 500).play();
            fadeMainMenu(setLab, setLab.getOpacity(), 0, 500).play();
        });

        exit.setOnMouseEntered(event -> {
            if (exit.getOpacity() >= 0.8) {
                if (background.getImage().equals(night)) {
                    exitBack.setFill(Color.WHITE);
                    exitLab.setTextFill(Color.BLACK);
                    fadeMainMenu(exitLab, exitLab.getOpacity(), 1, 500).play();
                    fadeMainMenu(exitBack, exitBack.getOpacity(), 0.7, 500).play();
                } else {
                    exitBack.setFill(Color.BLACK);
                    exitLab.setTextFill(Color.WHITE);
                    fadeMainMenu(exitBack, exitBack.getOpacity(), 0.7, 500).play();
                    fadeMainMenu(exitLab, exitLab.getOpacity(), 1, 500).play();
                }
            }
        });

        exit.setOnMouseExited(event -> {
            fadeMainMenu(exitBack, exitBack.getOpacity(), 0, 500).play();
            fadeMainMenu(exitLab, exitLab.getOpacity(), 0, 500).play();
        });

        exit.setOnAction(event -> {
            if (exit.getOpacity() >= 0.9) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Do you really want to exit from game?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get().equals(ButtonType.OK)) {
//                    MammadNobari.stop();
                    game.close();
                }
            }
        });

        FadeTransition blink = new FadeTransition(Duration.millis(1000));
        blink.setNode(anyKey);
        blink.setFromValue(1);
        blink.setToValue(0);
        blink.setCycleCount(Animation.INDEFINITE);
        blink.setAutoReverse(true);
        blink.play();

        scene.setOnMouseClicked(event -> {
            if (logo.getOpacity() == 1) {
                if (single.getOpacity() == 0) {
                    blink.stop();
                    fadeMainMenu(anyKey, 1, 0, 1000).play();
                    fadeMainMenu(anyBack, 0.7, 0, 1000).play();
                    translateLogo(logo).play();
                    translateLogo(logoBack).play();
                    FadeTransition fadeSingle = fadeMainMenu(single, 0, 1, 1000);
                    fadeSingle.play();
                    single.setDisable(false);
                    FadeTransition fadeMulti = fadeMainMenu(multi, 0, 1, 1000);
                    fadeMulti.setDelay(Duration.millis(500));
                    fadeMulti.play();
                    multi.setDisable(false);
                    FadeTransition fadeCustom = fadeMainMenu(custom, 0, 1, 1000);
                    fadeCustom.setDelay(Duration.millis(1000));
                    fadeCustom.play();
                    custom.setDisable(false);
                    FadeTransition fadeSetting = fadeMainMenu(setting, 0, 1, 1000);
                    fadeSetting.setDelay(Duration.millis(1500));
                    fadeSetting.play();
                    setting.setDisable(false);
                    FadeTransition fadeExit = fadeMainMenu(exit, 0, 1, 1000);
                    fadeExit.setDelay(Duration.millis(2000));
                    fadeExit.play();
                    exit.setDisable(false);
                }
            }
        });

        shiftTime.setId("menuDownButton");
        sound.setId("menuDownButton");
        single.setId("menuButton");
        multi.setId("menuButton");
        custom.setId("menuButton");
        setting.setId("menuButton");
        exit.setId("menuButton");
        scene.getStylesheets().add("src/Resources/CSS/button.css");
        root.getChildren().addAll(background, logoBack, anyBack, logo, anyKey, shiftTime, sound, single, singleBack, singleLab, multi, multiBack, multiLab, custom, customBack, customLab, setting, setBack, setLab, exit, exitBack, exitLab);

        return scene;
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

    private static TranslateTransition translateLogo(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000));
        translateTransition.setNode(node);
        translateTransition.setByY(-100);
        translateTransition.setAutoReverse(false);
        return translateTransition;
    }
}
