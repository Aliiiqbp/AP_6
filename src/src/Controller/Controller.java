package src.Controller;

import javafx.scene.Group;
import src.Model.Animal.Animal;
import src.Model.Animal.AnimalType;
import src.Model.Animal.Pet.NoneProducer.Cat;
import src.Model.Animal.Pet.NoneProducer.Dog;
import src.Model.Animal.Pet.Producer.Cow;
import src.Model.Animal.Pet.Producer.Hen;
import src.Model.Animal.Pet.Producer.Sheep;
import src.Model.Animal.Wild.Bear;
import src.Model.Animal.Wild.Lion;
import src.Model.Animal.Wild.Wild;
import src.Model.Farm.Farm;
import src.Model.Farm.Map.Cell;

import src.Model.Entity;
import src.Model.Product.*;
import src.Model.Salable;
import src.Model.Time;
import src.Model.WorkShop.WorkShop;

import java.nio.file.Path;
import java.util.ArrayList;

public class Controller {

    private double money;
    private Farm farm;
    private Time time;

    public Controller(Farm farm) {
        this.farm = farm;
        time = new Time();
        money = Static.INITIAL_MONEY;
    }

    public void initializeGame() {
//        Dog dog = new Dog(100, 100);
//        Cat cat = new Cat(300, 300);
//        Hen hen = new Hen(200,200);
//        Lion lion = new Lion(400,400);
//        Cow cow = new Cow(100,300);
//        Bear bear = new Bear(300,100);
//        Sheep sheep = new Sheep(400,500);
//        farm.getMap().addSalable(dog);
//        farm.getMap().addSalable(hen);
//        farm.getMap().addSalable(cat);
//        farm.getMap().addSalable(lion);
//        farm.getMap().addSalable(sheep);
//        farm.getMap().addSalable(bear);
//        farm.getMap().addSalable(cow);
//        Egg egg = new Egg(150,145);
//        farm.getMap().addSalable(egg);
    this.buyAnimal(AnimalType.HEN, 200,200);


    }

    public void updateLocation(Group root) {

        // here we move things!
        for (Salable salable : farm.getMap().getSalables()) {
            salable.getMovement().move();

            /////we should now call all the show() methods


            ///// here i'm just handling the show() method of Animalss
            if (salable instanceof Dog)
                ((Dog) salable).ShowDog(root);
            if (salable instanceof Cat)
                ((Cat) salable).ShowCat(root);
            if (salable instanceof Hen)
                ((Hen) salable).ShowHen(root);
            if (salable instanceof Sheep)
                ((Sheep) salable).ShowSheep(root);
            if (salable instanceof Cow)
                ((Cow) salable).ShowCow(root);
            if (salable instanceof Lion)
                ((Lion) salable).ShowLion(root);
            if (salable instanceof Bear)
                ((Bear) salable).ShowBear(root);

            ////// here we show our products
            if (salable instanceof Product)
                ((Product) salable).showProduct(root);
        }
        farm.getWell().showWell(root);
        farm.getWareHouse().showWarehouse(root);

    }

    public void buyAnimal(AnimalType animalType, double x, double y) {
        Animal animal = AnimalType.getPet(animalType, x, y);
        if (farm.getBank().canDecrease(animal.getBuyPrice())) {
            farm.getBank().buy(animal.getBuyPrice());
            farm.getMap().addSalable(animal);
        }
    } //ok

    private void pickUp(double x, double y) {
        Cell cell = farm.getMap().getMappedCell(x, y);
        ArrayList<Salable> salables = cell.getSalables();
        if (farm.getWareHouse().canAdd(salables)) {
            farm.getFarm().getWareHouse().add(salables);
            cell.clear();
        }
        cell.clear();
    }

    private void pickUp(Salable salable) {
        Cell cell = farm.getMap().getMappedCell(salable.getMovement().getCurrentX(), salable.getMovement().getCurrentY());
        if (farm.getWareHouse().canAdd(salable)) {
            farm.getWareHouse().add(salable);
            farm.getWareHouse().remove(salable);
        }
    }

    private void cageWild(double x, double y) {
    } // TODO: 12/24/2018  cage wild animal

    private void cageWild(Wild wild) {
        wild.cage();
    }

    private void plant(double x, double y) {
        Cell cell = farm.getMap().getMappedCell(x, y);
        Water water = farm.getWell().getWater();
        if (water != null) {
            Grass grass = Grass.getGrass(x, y, water);
            cell.addToCell(grass);
        }
    }

    private void fillWell() {
        if (farm.getBank().canDecrease(farm.getWell().getFillWellCost())) {
            farm.getBank().buy(farm.getWell().getFillWellCost());
            farm.getWell().chargeWell();
        }
    } // TODO: 12/24/2018 fill well

    private void clickWorkShop(WorkShop workShop) {
        ProductType requirement = workShop.getRequirement();
        Product product = ProductType.getProduct(requirement, workShop.getMovement().getCurrentX(), workShop.getMovement().getCurrentY());
        if (farm.getWareHouse().contain(product)) {
            farm.getWareHouse().remove(product);
            Product p = workShop.produce(product);
            farm.getMap().addSalable(p);
        }
    }// TODO: 12/25/2018 start[workshop_name]

    private void upgradeLevel(Entity object) {
        object.upgradeLevel();
    } // TODO: 12/25/2018 upgrade[workshop|cat|well]...]

    private void loadCustom(Path path) {
    } // TODO: 12/25/2018 load custom[path_to_custom_directory]

    private void run() {
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
    } // TODO: 12/25/2018 sell turn n time
}