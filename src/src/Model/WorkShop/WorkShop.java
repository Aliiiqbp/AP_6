package src.Model.WorkShop;

import src.Model.Coordinate.Movement;
import src.Model.Product.Product;
import src.Model.Product.ProductType;
import src.Model.Entity;
import src.Model.Salable;

public abstract class WorkShop extends Entity {

    private ProductType productType;
    private WorkShopType workShopType;
    private ProductType requirement;
    private int producingTime;
    private boolean isProducing;

    public WorkShop(WorkShopType workShopType, ProductType productType, ProductType requirement, int produceTime) {
        this.workShopType = workShopType;
        this.productType = productType;
        this.requirement = requirement;
        this.producingTime = produceTime;
        isProducing = false;
    }

    public boolean canProduce() {
        Product product = ProductType.getProduct(productType, Movement.getRandomX(), Movement.getRandomY());
        return getFarm().getWareHouse().contain(product);
    }

    public void produce() {
        if (canProduce()) {
            getFarm().getWareHouse().getSalable(ProductType.getProduct(productType, Movement.getRandomX(), Movement.getRandomY()));
            isProducing = true;
        }
    }

    public ProductType getProductType() {
        return productType;
    }

    public WorkShopType getWorkShopType() {
        return workShopType;
    }

    public double getProducingTime() {
        return producingTime;
    }

    public ProductType getRequirement() {
        return requirement;
    }

    @Override
    public void play() {
        getTime().turn();
        if (isProducing && getTime().getDuration() >= producingTime) {
            isProducing = false;
            getTime().restart();
            Product product = ProductType.getProduct(productType, Movement.getRandomX(), Movement.getRandomY());
            getFarm().getMap().addSalable(product);
        }
    }
}