package src.Model.WorkShop;

import src.Model.Entity;
import src.Model.Product.Product;
import src.Model.Product.ProductType;

import java.security.PublicKey;
import java.util.HashMap;

public abstract class WorkShop extends Entity {

    private ProductType productType;
    private WorkShopType workShopType;
    private HashMap<Product, Integer> requirements;

    public WorkShop(WorkShopType workShopType,HashMap<Product, Integer> requirements) {
        this.workShopType = workShopType;
        this.requirements = requirements;
    }

    public Product produce(Product... products) {
        // TODO: 12/31/2018 check requirements
        boolean result = false;

        return null;
    }

    public void changeRequirments(HashMap<Product, Integer> requirements) {
        this.requirements = requirements;
    }

    public WorkShopType getWorkShopType() {
        return workShopType;
    }

    public HashMap<Product, Integer> getRequirements() {
        return requirements;
    }
}