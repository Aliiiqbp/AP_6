package Model.Product;

import Controller.Static;

import java.security.PublicKey;

public class Cookie extends Product {

    public Cookie(double x, double y){
        super(ProductType.COOKIE, Static.COOKIE_SELL_VALUE, Static.COOKIE_BUY_COST, Static.COOKIE_VOLUME, x, y);
    }

}
