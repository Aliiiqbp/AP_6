package src.Model.WorkShop;

import src.Model.Product.Egg;
import src.Model.Product.ProductType;

import java.util.HashMap;

public class CakeBakery extends WorkShop {

    public CakeBakery() {
        super(WorkShopType.CAKE_BAKERY, ProductType.EGG);
        this.getRequirements().put(ProductType.EGG, 3);
        this.getRequirements().put(ProductType.WATER, 4);
    }

}
