package src.Model.Farm.Extra;

import src.Controller.Static;
import src.Model.Capacity;
import src.Model.Entity;
import src.Model.Salable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.FileInputStream;
import java.util.ArrayList;

public class WareHouse extends Entity {
    ImageView lastImageView = null;
    private Capacity capacity;

    public WareHouse() {
        this.capacity = new Capacity(Static.WAREHOUSE_CAPACITY_LVL_0);
    }

//    public void add(Salable salable, int count) {
//        this.capacity.add(salable, count);
//    }

    public void add(Salable salable) {
        this.capacity.add(salable);
    }

    public void add(ArrayList<Salable> salables) {
        this.capacity.add(salables);
    }

    public boolean canAdd(Salable salable) {
        return capacity.canAdd(salable);
    }

    public boolean canAdd(ArrayList<Salable> salables) {
        return capacity.canAdd(salables);
    }

//    public void remove(Salable salable, int count) {
//        this.capacity.remove(salable, count);
//    }

    public boolean contain(Salable salable) {
        return capacity.contain(salable);
    }

    public void remove(Salable salable) {
        this.capacity.remove(salable);
    }

    public Salable getSalable(Salable salable) {
        return capacity.getSalable(salable);
    }

    public int getNumberOfSalable(String salable) {
        return this.capacity.getNumberOfSalable(salable);
    }

    @Override
    public void upgradeLevel() {
        switch (getLevel()) {
            case 0:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_1);
                break;
            case 1:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_2);
                break;
            case 2:
                this.capacity.update(Static.WAREHOUSE_CAPACITY_LVL_3);
                break;
            case 3:
                break; // can't remove upgraded
        }
        this.upgradeLevel();
    }

    @Override
    public void play() {

    }

    public void showWarehouse(Group root){

        try {
            Image warehouseImage = new Image(new FileInputStream("src/Resources/Textures/Service/Depot/" + Integer.toString(0)  + Integer.toString(this.getLevel()) +".png"));
            ImageView warehouseView = new ImageView(warehouseImage);
            warehouseView.setX(250);
            warehouseView.setY(450);
            root.getChildren().remove(lastImageView);
            root.getChildren().add(warehouseView);


            warehouseView.setOnMouseClicked(event -> {
                // what should we do?

            });

            lastImageView = warehouseView;
        } catch (Exception e) {
        }


    }
}
