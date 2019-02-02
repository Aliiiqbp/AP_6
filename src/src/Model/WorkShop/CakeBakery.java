package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.Egg;
import src.Model.Product.ProductType;

import java.io.FileInputStream;
import java.util.HashMap;

public class CakeBakery extends WorkShop {

    public CakeBakery() {
        super(WorkShopType.CAKE_BAKERY, ProductType.CAKE, ProductType.COOKIE, Static.WORKSHOP_WORK_DURATION);
    }

    public void showCakeBakery(Group root) {
        try {
            Image CakeBakeryImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/CAKE_BAKERY/" + this.level + ".png"));
            ImageView CakeBakeryView = new ImageView(CakeBakeryImage);
            CakeBakeryView.setX(200);
            CakeBakeryView.setY(200);
            root.getChildren().add(CakeBakeryView);
        } catch (Exception e) {
        }
    }

}
