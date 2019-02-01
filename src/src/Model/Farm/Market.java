package src.Model.Farm;

import src.Model.Entity;
import src.Model.Product.Product;
import src.Model.Product.ProductType;

import java.util.ArrayList;

public class Market extends Entity {

    ArrayList<ProductType> productTypes;

    public Market() {
        this.productTypes = new ArrayList<>();
    }

    public void addToProducts(ProductType productType) {
        if (!productTypes.contains(productTypes)) {
            productTypes.add(productType);
        }
    }

    public Product getProduct(ProductType productType, double x, double y) {
        return ProductType.getProduct(productType, x, y);
    }

    public boolean contain(ProductType productType) {
        if (productTypes.contains(productType)) {
            return true;
        }
        return false;
    }
}