package src.Model.Coordinate;

import src.Model.Vehicle.Vehicle;
import src.Model.WorkShop.WorkShop;

public class Movement {
    Direction direction;
    private double speed;
    private double currentX, currentY;
    private boolean isInFastRun;

    private  double fixedX = -1, fixedY = -1;

    public Movement(double speed, double currentX, double currentY) {
        // Direction is set arbitrary to right
        this.direction = Direction.RIGHT; // TODO: 12/28/2018 set direction
        this.speed = speed;
        this.currentX = currentX;
        this.currentY = currentY;
        this.isInFastRun = false;
    }

    public Movement() {
        this.direction = Direction.NONE; // TODO: 12/28/2018 set direction
        this.speed = 0.0;
        this.currentX = fixedX;
        this.currentY = fixedY; // TODO: 1/25/2019 set well movement 
    }

    public Direction getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void boostSpeed() {
        if (!isInFastRun) {
            isInFastRun = true;
            speed *= 2;
        }
    }

    public void reduceSpeed() {
        if (isInFastRun) {
            isInFastRun = false;
            speed /= 2;
        }
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void move() {
        // TODO: 1/31/2019 things have to be in map
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

    public void stop() { // TODO: 12/29/2018 we need a better name for this function
        this.speed = 0;
        this.direction = Direction.NONE;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static Direction bfs(Movement start, Movement finish){

        Direction result = Direction.NONE;

        if (start.currentX == finish.currentX){
            if (start.currentY > finish.currentY){
                result = Direction.UP;
            } else if (start.currentY < finish.currentY){
                result = Direction.DOWN;
            } else {
                result = Direction.NONE;
            }
        }

        if (start.currentY == finish.currentY){
            if (start.currentX > finish.currentX){
                result = Direction.LEFT;
            } else if (start.currentX < finish.currentX){
                result = Direction.RIGHT;
            } else {
                result = Direction.NONE;
            }
        }

        if (start.currentX > finish.currentX && start.currentY < finish.currentY){
            result = Direction.DOWN_LEFT;
        } else if (start.currentX < finish.currentX && start.currentY < finish.currentY){
            result = Direction.DOWN_RIGHT;
        } else if (start.currentX < finish.currentX && start.currentY > finish.currentY){
            result = Direction.UP_RIGHT;
        } else if (start.currentX > finish.currentX && start.currentY > finish.currentY){
            result = Direction.UP_LEFT;
        }

        return result;
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
