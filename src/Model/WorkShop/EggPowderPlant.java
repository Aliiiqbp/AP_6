package src.Model.WorkShop;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Product.ProductType;

import java.io.FileInputStream;

public class EggPowderPlant extends WorkShop {
    public EggPowderPlant(WorkShopType workShopType, ProductType productType) {
        super(workShopType.EGG_POWDER_PLANT, productType.EGG_POWDER);
        this.getRequirements().put(productType.EGG, (int) Static.LVL1);
    }

    public void showEggPowderPlant(Group root) {
        try {
            Image EggPowderPlantImage = new Image(new FileInputStream("src/src/Resources/Textures/Workshops/EGG_POWDER_PLANT/" + this.level + ".png"));
            ImageView EggPowderPlantView = new ImageView(EggPowderPlantImage);
            EggPowderPlantView.setX(this.getMovement().getCurrentX());
            EggPowderPlantView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(EggPowderPlantView);
        } catch (Exception e) {
        }
    }
}
