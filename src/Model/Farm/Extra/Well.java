package src.Model.Farm.Extra;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import src.Controller.Static;
import src.GUI.AnimalSpriteAnimation;
import src.Model.Building;
import src.Model.Coordinate.Movement;
import src.Model.Entity;
import src.Model.Product.Water;

import java.io.FileInputStream;

public class Well extends Building {
    private int wellCapacity;
    private int amountOfWater;
    private double fillWellCost;
    private Movement movement;
    protected ImageView lastImageView = null;

    public Well() {
        wellCapacity = Static.WELL_CAPACITY_LVL_0;
        amountOfWater = 0;
        fillWellCost = Static.WELL_FILL_COST_LVL_0;
        movement = new Movement();
    }

    @Override
    public void upgradeLevel() {
        switch (getLevel()) {
            case 0:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_1);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_1);
                break;
            case 1:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_2);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_2);
                break;
            case 2:
                this.setFillWellCost(Static.WELL_FILL_COST_LVL_3);
                this.setWellCapacity(Static.WELL_CAPACITY_LVL_3);
                break;
            case 3: //it's not upgradable :)
                break;
        }
        increaseLevel();
    }

    public double getAmountOfWater() {
        return amountOfWater;
    }

    public double getWellCapacity() {
        return wellCapacity;
    }

    public double wellChargeCost() {
        return fillWellCost;
    }

    public void chargeWell() {
        // TODO: 12/31/2018 remove money for charge = (wellCapacity - amountOfWater)/wellCapacity * chargeCost
        // if money ok
        this.amountOfWater = this.wellCapacity;
    }

    public Water buyWater() {
        if (amountOfWater > 0 ) {
            amountOfWater -= 1;
            return new Water(this.movement.getCurrentX(), this.movement.getCurrentY());
        }
        return null;
    } // TODO: 1/31/2019 fix this shit


    private void setFillWellCost(double fillWellCost) {
        this.fillWellCost = fillWellCost;
    }

    private void setWellCapacity(int wellCapacity) {
        this.wellCapacity = wellCapacity;
    }

    public double getFillWellCost() {
        return fillWellCost;
    }


    public void showWell(Group root){
        try {
            Image wellImage = new Image(new FileInputStream("src/Resources/Textures/Service/Well/" + Integer.toString(0)  + Integer.toString(this.getLevel()) +".png"));
            ImageView wellView = new ImageView(wellImage);
            wellView.setX(580);
            wellView.setY(40);
            root.getChildren().remove(lastImageView);
            root.getChildren().add(wellView);

            final int count = 16;
            final int durationTime = 2000, offsetX = 0, offsetY = 0;
            int columns = 4, width = (int) wellImage.getWidth(), height = (int) wellImage.getHeight();


            wellView.setViewport(new Rectangle2D(0, 0, width, height));    //sprite animation  useful for your project
            final Animation animation = new AnimalSpriteAnimation(
                    wellView,
                    Duration.millis(durationTime),
                    count, columns,
                    offsetX, offsetY,
                    (int) Math.ceil(1.0 * width / columns), (int) Math.ceil(1.0 * height / (1.0 * count / columns))
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();

            wellView.setOnMouseClicked(event -> {
                ///// it fills the well
                this.chargeWell();

            });

            lastImageView = wellView;
        } catch (Exception e) {
        }

    }
}
