package src.Model.Product;

import src.Controller.Static;

public class Wool extends  Product{
    public Wool(double x, double y){
        super(ProductType.WOOL, Static.WOOL_SELL_VALUE, Static.WOOL_BUY_COST, Static.WOOL_VOLUME, x, y);
    }
}