import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    private double x;
    private double y;
    private Orientation orientation;
    private enum Orientation{
        UP,
        LEFT,
        DOWN,
        RIGHT
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        x=0;
        y=0;
        orientation=Orientation.UP;
        stopEngine();
    }

    public Car(){
        this(0, 0, null, null);
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed>enginePower){
            currentSpeed=enginePower;
        }
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed<0){
            currentSpeed=0;
        }
    }

    public void move(){
        switch (orientation){
            case RIGHT:
                x+=currentSpeed;
                break;
            case LEFT:
                x-=currentSpeed;
            case UP:
                y+=currentSpeed;
                break;
            case DOWN:
                y-=currentSpeed;
                break;
        }
    }

    public void turnLeft(){
        orientation=Orientation.values()[(orientation.ordinal()+1)%4];
    }

    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void gas(double amount){
        if (amount<0||amount>1){
            throw new IllegalArgumentException();
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount<0||amount>1){
            throw new IllegalArgumentException();
        }
        decrementSpeed(amount);
    }



}
