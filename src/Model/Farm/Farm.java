package src.Model.Farm;

import src.Controller.Static;
import src.Model.Farm.Extra.WareHouse;
import src.Model.Farm.Extra.Well;
import src.Model.Farm.Map.Map;
import src.Model.Entity;

public class Farm extends Entity {
    private Map map;
    private Bank bank;
    private Well well;
    private WareHouse wareHouse;

    public Farm() {
        this.map = new Map(Static.MAP_BASE_WIDTH, Static.MAP_BASE_HEIGHT);
        this.bank = new Bank();
        this.well = new Well();
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
}