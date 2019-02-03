package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class SewingFactory extends WorkShop {
    public SewingFactory() {
        super(WorkShopType.SEWING_FACTORY, ProductType.SEWING, ProductType.WOOL, Static.WORKSHOP_WORK_DURATION);
    }

    public void showSewingFactory(Group root) {
        try {
            Image SewingFactoryImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/SEWING_FACTORY/" + this.level + ".png"));
            ImageView SewingFactoryView = new ImageView(SewingFactoryImage);
//            SewingFactoryView.setX(this.getMovement().getCurrentX());
//            SewingFactoryView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(SewingFactoryView);
        } catch (Exception e) {
        }
    }
}
