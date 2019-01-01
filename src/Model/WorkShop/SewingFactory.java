package src.Model.WorkShop;

import src.Controller.Static;
import src.Model.Product.ProductType;

public class SewingFactory extends WorkShop {
    public SewingFactory(WorkShopType workShopType, ProductType productType) {
        super(workShopType.SEWING_FACTORY, productType.SEWING);
        this.getRequirements().put(productType.WOOL, (int) Static.LVL1);
    }
}
