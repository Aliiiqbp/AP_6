package Model.Product;

import Controller.Static;

public class CarnnivalDress extends Product {

    public CarnnivalDress(double x, double y){
        super(ProductType.CARNIVAL_DRESS, Static.CARNIVALDRESS_SELL_VALUE, Static.CARNIVALDRESS_BUY_COST, Static.CARNIVALDRESS_VOLUME, x, y);
    }
}
