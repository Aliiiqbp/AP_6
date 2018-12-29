package src.Model.Coordinate;

import src.Model.Vehicle.Vehicle;
import src.Model.WorkShop.WorkShop;

public class Movement {
    Direction direction;
    private double speed;
    private double currentX, currentY;
    private double targetX, targetY;

    public Movement(double speed, double currentX, double currentY) {
        this.direction = Direction.NONE; // TODO: 12/28/2018 set direction
        this.speed = speed;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public Direction getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public double getTargetX() {
        return targetX;
    }

    public double getTargetY() {
        return targetY;
    }

    public void move() {
        switch (direction) {
            case UP:
                currentY -= speed;
                break;
            case RIGHT:
                currentX += speed;
                break;
            case DOWN:
                currentY += speed;
                break;
            case LEFT:
                currentX -= speed;
                break;
            case UP_RIGHT:
                currentX += (speed/Math.sqrt(2));
                currentY -= (speed/Math.sqrt(2));
                break;
            case UP_LEFT:
                currentX -= (speed/Math.sqrt(2));
                currentY -= (speed/Math.sqrt(2));
                break;
            case DOWN_RIGHT:
                currentX += (speed/Math.sqrt(2));
                currentY += (speed/Math.sqrt(2));
                break;
            case DOWN_LEFT:
                currentX -= (speed/Math.sqrt(2));
                currentY += (speed/Math.sqrt(2));
                break;
            case NONE: break;
            default: break;
        }

        // TODO: 12/28/2018 set next Direction
        return;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void catched() { // TODO: 12/29/2018 we need a better name for this function 
        this.speed = 0;
        this.direction = Direction.NONE;
    }
    
    public void moveToWareHouse() { 
        // TODO: 12/29/2018  
    }
    
    public void moveToWorkShop(WorkShop workShop) {
        // TODO: 12/29/2018  
    }
    
    public void moveToVehicle(Vehicle vehicle) {
        // TODO: 12/29/2018  
    }
}
