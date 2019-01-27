package src.GUI;

//import graphic.Handle.Group;
//import graphic.Handle.Graphic_Handler;
//import graphic.Handle.environment.farm.home.Home_Graphic;
//import graphic.Handle.environment.jungle.Jungle_Graphic;
//import graphic.Handle.environment.village.Village_Graphic;
//import graphic.Handle.farmer.Farmer_Graphic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import src.Model.Animal.Pet.NoneProducer.Dog;
import src.Model.Coordinate.Direction;


public class FarmGraphic {
    private static Group root;
    private static Timeline interact;

    public static void farmScene(String where) {
        ImageView background = new ImageView(new Image("src/Resources/Textures/back.png"));

        root = new Group(background);

        if (GraphicHandler.isOnline) {
//            root.addOnlineButtons();
        }



        Dog dog = new Dog(100,100);
//        setStart(where);
//        Farmer_Graphic.setFarmerBools(root);

//        Farmer_Graphic.moveFarmer(root);


        dog.ShowDog(root, Direction.RIGHT);
        Scene scene = new Scene(root, 800, 600);
        GraphicHandler.game.setScene(scene);

//        moveInFarm();
    }

//    private static void moveInFarm() {
//        interact = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
//            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 5
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 572
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 620) {
//                Farmer_Graphic.move.stop();
//                interact.stop();
//                root.animation.stop();
//                Jungle_Graphic.jungleScene("farm");
//            }
//            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1310
//                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1390
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 5) {
//                Farmer_Graphic.move.stop();
//                interact.stop();
//                root.animation.stop();
//                Group.isInVillage = true;
//                Village_Graphic.villageScene("farm");
//            }
//            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 480 && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 520
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 380 && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 360) {
//                Farmer_Graphic.move.stop();
//                interact.stop();
//                root.animation.stop();
//                Home_Graphic.homeScene("farm");
//            }
//            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 570
//                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 650
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1190
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1470) {
//                Group.inspect.setOpacity(0.7);
//                Group.inspect.setOnMouseClicked(event1 -> {
//
//                });
//            }
//            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1270
//                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1380
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1100
//                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 1470) {
//                Group.inspect.setOpacity(0.7);
//                Group.inspect.setOnMouseClicked(event1 -> {
//
//                });
//            }
//            else {
//                Group.inspect.setOpacity(0);
//            }
//        }));
//        interact.setCycleCount(Animation.INDEFINITE);
//        interact.play();
//    }

//    private static void setStart(String where) {
//        if(where.equals("start")) {
//            root.getImage().setTranslateX(-30);
//            root.getImage().setTranslateY(-100);
//            root.getPlayer().setLayoutX(480);
//            root.getPlayer().setLayoutY(356.25);
//        }
//        if(where.equals("jungle")) {
//            root.getImage().setTranslateX(0);
//            root.getImage().setTranslateY(-271.2);
//            root.getPlayer().setLayoutX(33);
//            root.getPlayer().setLayoutY(356.3);
//        }
//        if(where.equals("village")) {
//            root.getImage().setTranslateX(-640);
//            root.getImage().setTranslateY(0);
//            root.getPlayer().setLayoutX(707);
//            root.getPlayer().setLayoutY(24);
//        }
//        if(where.equals("home")) {
//            root.getImage().setTranslateX(-30);
//            root.getImage().setTranslateY(-100);
//            root.getPlayer().setLayoutX(480);
//            root.getPlayer().setLayoutY(356.25);
//        }
//    }
}