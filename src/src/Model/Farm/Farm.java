package src.Model.Farm;

import src.Controller.Static;
import src.Model.Farm.Extra.WareHouse;
import src.Model.Farm.Extra.Well;
import src.Model.Farm.Map.Map;
import src.Model.Entity;
import src.Model.Time;
import src.Model.WorkShop.WorkShop;

import java.util.ArrayList;

public class Farm extends Entity {
    private Map map;
    private Bank bank;
    private Well well;
    private WareHouse wareHouse;
    private Market market;
    private Time time;
    private ArrayList<WorkShop> workShops;

    public Farm() {
        this.map = new Map(Static.MAP_BASE_WIDTH, Static.MAP_BASE_HEIGHT);
        this.bank = new Bank();
        this.well = new Well();
        this.market = new Market();
        this.wareHouse = new WareHouse();
        this.workShops = new ArrayList<>();
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

    @Override
    public void play() {
        map.play();
        well.play();
        wareHouse.play();
        for (WorkShop workshop: workShops) {
            workshop.play();
        }
    }
}