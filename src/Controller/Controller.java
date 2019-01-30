package Controller;

import javafx.scene.Group;
import Model.Animal.Animal;
import Model.Animal.AnimalType;
import Model.Animal.Pet.NoneProducer.Cat;
import Model.Animal.Pet.NoneProducer.Dog;
import Model.Animal.Wild.Wild;
import Model.Farm.Extra.WareHouse;
import Model.Farm.Farm;
import Model.Farm.Map.Cell;

import Model.Entity;
import Model.Product.Grass;
import Model.Product.Product;
import Model.Product.ProductType;
import Model.Product.Water;
import Model.Salable;
import Model.Time;
import Model.WorkShop.WorkShop;
import Model.WorkShop.WorkShopType;
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


    public void initializeGame(){
        Dog dog1 = new Dog(100, 100);
        Dog dog2 = new Dog(200,200);
        Cat cat1 = new Cat(300,300);
        farm.getMap().addSalable(dog1);
        farm.getMap().addSalable(dog2);
        farm.getMap().addSalable(cat1);


    }

    public void updateLocation(Group root){

        // here we move things!
        for (Salable salable : farm.getMap().getSalables()){
            salable.getMovement().move();

            //we should now call all the show() methods
            // here i'm just handling the show() method of cat and dog
            if (salable instanceof Dog)
                ((Dog) salable).ShowDog(root);
            if (salable instanceof Cat)
                ((Cat) salable).ShowCat(root);
        }



    }

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