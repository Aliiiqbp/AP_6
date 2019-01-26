package src.Controller;

import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Wild.Wild;
import src.Model.Farm.Extra.WareHouse;
import src.Model.Farm.Farm;
import src.Model.Farm.Map.Cell;
import src.Model.Farm.Map.Map;

import src.Model.Entity;
import src.Model.Product.Grass;
import src.Model.Product.Product;
import src.Model.Product.ProductType;
import src.Model.Product.Water;
import src.Model.Salable;
import src.Model.Time;
import src.Model.WorkShop.WorkShop;
import src.Model.WorkShop.WorkShopType;
import src.View.IO;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private double money;
    private Farm farm ;
    private Time time ;
    private WareHouse wareHouse;

    public Controller(Farm farm) {
        this.farm = farm ;
        time = new Time();
        money = Static.INITIAL_MONEY;
    }

    public void getCommand() {
        String[] strings = IO.splitCommand();

    } // TODO: 12/24/2018 set IO with function

    private void buyAnimal(AnimalType animalType, double x, double y) {
        Animal animal = AnimalType.getPet(animalType, x, y);
        farm.getMap().addSalable(animal);
    } //ok

    private void pickUp(double x, double y) {
        Cell cell = farm.getMap().getMappedCell(x, y);
        ArrayList<Salable> salables = cell.getSalables();
        if (wareHouse.canAdd(salables)) {
            wareHouse.add(salables);
            cell.clear();
        }
        cell.clear();
    } // TODO: 12/24/2018 pickUp product

    public void pickUp(Salable salable) {
        Cell cell = farm.getMap().getMappedCell(salable.getMovement().getCurrentX(), salable.getMovement().getCurrentY());
        if (wareHouse.canAdd(salable)) {
            wareHouse.add(salable);
            wareHouse.remove(salable);
        }
    }

    private void cageWild(double x, double y) {
    } // TODO: 12/24/2018  cage wild animal

    private void cageWild(Wild wild) {
        wild.cage();
    }

    private void plant(double x, double y, Water water) {
        Cell cell = farm.getMap().getMappedCell(x,y);
        Grass grass = Grass.getGrass(x, y, water);
        cell.addToCell(grass);
    } // TODO: 12/24/2018 plant Grass

    private void fillWell() {
        farm.getWell().chargeWell();
    } // TODO: 12/24/2018 fill well

    private Product clickWorkShop(WorkShop workShop, Product... products) {
        if (workShop.canProduce(products)) {
            return workShop.produce(products);
        }
        return null;
    }// TODO: 12/25/2018 start[workshop_name]

    private void upgradeLevel(Entity object) {
        object.upgradeLevel();
    } // TODO: 12/25/2018 upgrade[workshop|cat|well]...]

    private void loadCustom(Path path) {
    } // TODO: 12/25/2018 load custom[path_to_custom_directory]

    private void run()
    {
        farm.getMap().run();
        // TODO: 1/25/2019 fix margin
    } // TODO: 12/25/2018 run the game

    private void saveGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void loadGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void printInfo(Entity object) {
    } // TODO: 12/25/2018  print info of object

    private void turn(int n) {
    } // TODO: 12/25/2018 increase turn n time
}