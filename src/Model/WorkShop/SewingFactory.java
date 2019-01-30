package Model.WorkShop;

import Controller.Static;
import Model.Product.ProductType;

public class SewingFactory extends WorkShop {
    public SewingFactory(WorkShopType workShopType, ProductType productType) {
        super(workShopType.SEWING_FACTORY, productType.SEWING);
        this.getRequirements().put(productType.WOOL, (int) Static.LVL1);
    }
}
