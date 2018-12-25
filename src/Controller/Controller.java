package src.Controller;

import src.Model.Animal.AnimalType;
import src.Model.Farm.Map.Map;
import src.Model.NTT;
import src.Model.WorkShop.WorkShopType;

import java.nio.file.Path;

public class Controller {

    public void getCommand() {
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

    private void upgradeLevel(NTT ntt) {
    } // TODO: 12/25/2018 upgrade[workshop|cat|well]...]

    private void loadCustom(Path path) {
    } // TODO: 12/25/2018 load custom[path_to_custom_directory]

    private void run(Map map) {
    } // TODO: 12/25/2018 run the game

    private void saveGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void loadGame(Path path) {
    } // TODO: 12/25/2018 save game [path_to_json_file]

    private void printInfo(NTT ntt) {
    } // TODO: 12/25/2018  print info of object

    private void turn(int n) {
    } // TODO: 12/25/2018 increase turn n time
}
