package src.Model.WorkShop;

import src.Controller.Static;
import src.Model.Product.ProductType;

public class CookieBakery extends WorkShop {
    public CookieBakery(WorkShopType workShopType, ProductType productType) {
        super(workShopType.COOKIE_BAKERY, productType.COOKIE);
        this.getRequirements().put(productType.EGGPOWDER, (int) Static.LVL1);
    }
}
