package Model.Coordinate;

import Model.Vehicle.Vehicle;
import Model.WorkShop.WorkShop;

public class Movement {
    Direction direction;
    private double speed;
    private double currentX, currentY;
    private double targetX, targetY;

    private  double fixedX = -1, fixedY = -1;

    public Movement(double speed, double currentX, double currentY) {
        // Directioon is set arbitrary to right
        this.direction = Direction.RIGHT; // TODO: 12/28/2018 set direction
        this.speed = speed;
        this.currentX = currentX;
        this.currentY = currentY;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void stop() { // TODO: 12/29/2018 we need a better name for this function
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
