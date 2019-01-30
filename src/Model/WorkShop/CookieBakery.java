package Model.WorkShop;

import Controller.Static;
import Model.Product.ProductType;

public class CookieBakery extends WorkShop {
    public CookieBakery(WorkShopType workShopType, ProductType productType) {
        super(workShopType.COOKIE_BAKERY, productType.COOKIE);
        this.getRequirements().put(productType.EGG_POWDER, (int) Static.LVL1);
    }
}
