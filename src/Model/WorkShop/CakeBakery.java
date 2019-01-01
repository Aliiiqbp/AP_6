package src.Model.WorkShop;

import src.Controller.Static;
import src.Model.Product.Egg;
import src.Model.Product.ProductType;

import java.util.HashMap;

public class CakeBakery extends WorkShop {

    public CakeBakery() {
        super(WorkShopType.CAKE_BAKERY, ProductType.CAKE);
        this.getRequirements().put(ProductType.COOKIE, (int) Static.LVL1);
        this.getRequirements().put(ProductType.FLOUR, (int) Static.LVL1);
    }

}
