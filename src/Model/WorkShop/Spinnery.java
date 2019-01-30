package Model.WorkShop;

import Controller.Static;
import src.Model.Product.ProductType;

public class Spinnery extends WorkShop {
    public Spinnery(WorkShopType workShopType, ProductType productType) {
        super(workShopType.SPINNERY, productType.SEWING);
        this.getRequirements().put(productType.WOOL, (int) Static.LVL1);
    }
}
