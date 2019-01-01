package src.Model.WorkShop;

import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Product.Product;
import src.Model.Product.ProductType;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class WorkShop extends Entity {

    private ProductType productType;
    private WorkShopType workShopType;
    private HashMap<ProductType, Integer> requirements;
    private Movement movement;

    public WorkShop(WorkShopType workShopType, ProductType productType) {
        this.workShopType = workShopType;
        this.productType = productType;
        movement = new Movement();
    }

    public Product produce(Product... products) {
        // TODO: 12/31/2018 send error message if requirements not found
        if (canProduce(products)) {
            return ProductType.getProduct(this.productType, this.movement.getCurrentX(), this.movement.getCurrentY());
        }

        return null;
    }

    public boolean canProduce(Product... products) {
        Set<ProductType> productTypeSet = requirements.keySet();
        HashMap<ProductType, Integer> productList = ProductType.changeToHashMap(products);

        boolean result = true;
        for (ProductType productType :productTypeSet) {
            if (requirements.get(productType) != productList.get(productType)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void changeRequirments(HashMap<ProductType, Integer> requirements) {
        this.requirements = requirements;
    }

    public WorkShopType getWorkShopType() {
        return workShopType;
    }

    public HashMap<ProductType, Integer> getRequirements() {
        return requirements;
    }
}