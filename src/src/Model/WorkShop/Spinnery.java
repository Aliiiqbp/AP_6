package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class Spinnery extends WorkShop {
    public Spinnery() {
        super(WorkShopType.SPINNERY, ProductType.SEWING, ProductType.WOOL, Static.WORKSHOP_WORK_DURATION);
    }

    public void showSpinnery(Group root) {
        try {
            Image SpinneryImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/SPINNERY/" + this.level + ".png"));
            ImageView SpinneryView = new ImageView(SpinneryImage);
//            SpinneryView.setX(this.getMovement().getCurrentX());
//            SpinneryView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(SpinneryView);
        } catch (Exception e) {
        }
    }
}
