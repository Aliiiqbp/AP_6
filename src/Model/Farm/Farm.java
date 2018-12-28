package src.Model.Farm;

import src.Model.Farm.Extra.Well;
import src.Model.Farm.Map.Map;
import src.Model.Entity;




public class Farm extends Entity {
    public Map map;
    public Well well;

    public Farm() {
        int n = 10; // TODO we will handle different sizes of map later, for now n is 10
        map = new Map( n );
        well = new Well();
    }
}