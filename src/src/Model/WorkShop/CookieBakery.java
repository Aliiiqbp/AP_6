package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class CookieBakery extends WorkShop {
    public CookieBakery(WorkShopType workShopType, ProductType productType) {
        super(workShopType.COOKIE_BAKERY, productType.COOKIE);
        this.getRequirements().put(productType.EGG_POWDER, (int) Static.LVL1);
    }

    public void showCookieBakery(Group root) {
        try {
            Image CookieBakeryImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/COOKIE_BAKERY/" + this.level + ".png"));
            ImageView CookieBakeryView = new ImageView(CookieBakeryImage);
            CookieBakeryView.setX(this.getMovement().getCurrentX());
            CookieBakeryView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(CookieBakeryView);
        } catch (Exception e) {
        }
    }
}
