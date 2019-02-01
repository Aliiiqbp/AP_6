package src.Model.Vehicle;

import src.Controller.Static;
import src.Model.Product.Product;
import src.Model.Product.ProductType;
import src.Model.Salable;

public class Helicopter extends Vehicle {
    private double scatteringRadius;

    public Helicopter() {
        super(Static.HELI_CAPACITY_VOLUME_RADIUS_LVL_0, Static.HELI_TRAVEL_DURATION_LVL_0);
        this.scatteringRadius = Static.HELI_SCATTERING_RADIUS_LVL_0;
    }

    public void addToArrayList(ProductType productType) {
        Product product = getFarm().getMarket().getProduct(productType, 0, 0); // TODO: 1/31/2019 handle movement
        if (getFarm().getBank().canDecrease(product.getBuyPrice()) && getFarm().getMarket().contain(product.getProductType())) {
            getFarm().getBank().buy(product.getBuyPrice());
            addToList(product);
        }
    }

    public void removeFromArrayList(Product product) {
        if (getCapacity().getList().contains(product)) {
            getFarm().getBank().sell(product.getBuyPrice());
        }
    }

    public void buy() {
        getFarm().getMap().addSalables(this.getCapacity().getList());
        this.getCapacity().clear();
        // TODO: 1/31/2019 check
    }


    @Override
    public void upgradeLevel() {
        switch (level){
            case 0 :
                this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_1 );
                 this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_1);
                 break;
            case 1 :
                this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_2 );
                this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_2);
                break;
            case 2 :
                this.setTravelDuration( Static.HELI_TRAVEL_DURATION_LVL_3 );
                this.setScatteringRadius( Static.HELI_SCATTERING_RADIUS_LVL_3);
                break;
            case 3 : //it's not upgradable :)
                break;
        }
        increaseLevel();
    }



    public void setScatteringRadius(double scatteringRadius) {
        this.scatteringRadius = scatteringRadius;
    }

    public double getScatteringRadius() {
        return scatteringRadius;
    }

}
