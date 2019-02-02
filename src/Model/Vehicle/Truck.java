package src.Model.Vehicle;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Static;
import src.Model.Salable;

import java.io.FileInputStream;

public class Truck extends Vehicle {
    private double boxCount;
    private double boxCapacity;

    public Truck() {
        super(Static.TRUCK_CAPACITY_VOLUME_RADIUS_LVL_0 , Static.TRUCK_TRAVEL_DURATION_LVL_0);
        this.boxCapacity = Static.TRUCK_BOX_CAPACITY;
        this.boxCount = Static.TRUCK_BOX_COUNT_LVL_0;
    }

    public void addToCapacity(Salable salable) {
        if (getCapacity().canAdd(salable)) {
            getCapacity().add(salable);
            getFarm().getWareHouse().remove(salable);
        }
    }

    public void sell() {
        // TODO: 1/31/2019 check
        double totalMoney = 0;
        for (Salable salable: getCapacity().getList()) {
            totalMoney += getCapacity().getNumberOfSalable(salable.getClass().getName())*salable.getSellPrice();
        }
        getFarm().getBank().sell(totalMoney);
    }

    @Override
    public void upgradeLevel() { // TODO: 1/1/2019 sell Level
        switch (level){
            case 0 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_1 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_1);
                break;
            case 1 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_2 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_2);
                break;
            case 2 :
                this.setTravelDuration( Static.TRUCK_TRAVEL_DURATION_LVL_3 );
                this.setBoxCount( Static.TRUCK_BOX_COUNT_LVL_3);
                break;
            case 3 : //it's not upgradable :)
                break;
        }
        increaseLevel();
    }

    public void setBoxCount(double boxCount) {
        this.boxCount = boxCount;
    }

    public void showTruck(Group root) {
        try {
            Image truckImage = new Image(new FileInputStream("src/src/Resources/Textures/Service/Truck" + this.level + ".png"));
            ImageView truckView = new ImageView(truckImage);
//            truckView.setX(this.getMovement().getCurrentX());
//            truckView.setY(this.getMovement().getCurrentY());
            root.getChildren().add(truckView);
        } catch (Exception e) {
        }
    }
}