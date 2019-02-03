package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class WeavingFactory extends WorkShop{
    public WeavingFactory() {
        super(WorkShopType.WEAVING_FACTORY, ProductType.FABRIC, ProductType.SEWING, Static.WORKSHOP_WORK_DURATION);
    }

    public void showWeavingFactory(Group root) {
        try {
            Image WeavingFactoryImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/WEAVING_FACTORY/" + this.level + ".png"));
            ImageView WeavingFactoryView = new ImageView(WeavingFactoryImage);
//            WeavingFactoryView.setX(this.getMovement().getCurrentX());
//            WeavingFactoryView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(WeavingFactoryView);
        } catch (Exception e) {
        }
    }

}
