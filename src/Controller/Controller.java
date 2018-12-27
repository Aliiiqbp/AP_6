package src.Controller;

import src.Model.Animal.AnimalType;
import src.Model.Entity;
import src.Model.Farm.Farm;
import src.Model.Farm.Map.Map;

import src.Model.Time;
import src.Model.WorkShop.WorkShopType;
import src.View.IO;

import java.nio.file.Path;

public class Controller {

    private double money;
    public Farm farm ;
    public Time time ;

    public Controller() {
        farm = new Farm();
        time = new Time();
        money = Static.INITIAL_MONEY;
    }

    public void getCommand() {
        String[] strings = IO.splitCommand();

        if (strings[0].equals("Well")){
            farm.well.setAmountOfWater( farm.well.getWellCapacity() );        //handling the well command
        }

    } // TODO: 12/24/2018 set IO with function

    private void buyAnimal(AnimalType animalType) {
    } // TODO: 12/24/2018 buy animal API

    private void pickUp(double x, double y) {
    } // TODO: 12/24/2018 pickUp product

    private void cageWild(double x, double y) {
    } // TODO: 12/24/2018  hunt wild animal

    private void plant(double x, double y) {
    } // TODO: 12/24/2018 plant Grass

    private void fillWell() {
    } // TODO: 12/24/2018 fill well

    private void clickWorkShop(WorkShopType workShopType) {
    }// TODO: 12/25/2018 start[workshop_name]

    private void upgradeLevel(Entity entity) {
    } // TODO: 12/25/2018 upgrade[workshop|cat|well]...]

    private void loadCustom(Path path) {
    } // TODO: 12/25/2018 load custom[path_to_custom_directory]

    private void run(Map map) {
    } // TODO: 12/25/2018 run the game

    private void saveGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void loadGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void printInfo(Entity entity) {
    } // TODO: 12/25/2018  print info of object

    private void turn(int n) {
    } // TODO: 12/25/2018 increase turn n time
}