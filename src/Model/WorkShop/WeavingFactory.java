package Model.WorkShop;

import Controller.Static;
import Model.Product.ProductType;

public class WeavingFactory extends WorkShop{
    public WeavingFactory() {
        super(WorkShopType.WEAVING_FACTORY, ProductType.FABRIC);
        this.getRequirements().put(ProductType.SEWING, (int) Static.LVL1);
    }

}
