package Model.Farm;

import Controller.Static;
import Model.Farm.Extra.WareHouse;
import Model.Farm.Extra.Well;
import Model.Farm.Map.Map;
import Model.Entity;

public class Farm extends Entity {
    private Map map;
    private Bank bank;
    private Well well;
    private WareHouse wareHouse;
    private Market market;

    public Farm() {
        this.map = new Map(Static.MAP_BASE_WIDTH, Static.MAP_BASE_HEIGHT);
        this.bank = new Bank();
        this.well = new Well();
        this.market = new Market();
    }

    public Map getMap() {
        return map;
    }

    public Bank getBank() {
        return bank;
    }

    public Well getWell() {
        return well;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public Market getMarket() {
        return market;
    }
}