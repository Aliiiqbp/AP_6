package src.Model.WorkShop;

import src.Controller.Static;
import src.Model.Product.ProductType;

public class EggPowderPlant extends WorkShop {
    public EggPowderPlant(WorkShopType workShopType, ProductType productType) {
        super(workShopType.EGG_POWDER_PLANT, productType.EGG_POWDER);
        this.getRequirements().put(productType.EGG, (int) Static.LVL1);
    }
}
