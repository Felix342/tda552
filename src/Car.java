import java.awt.*;

/**
 * Abstract class containing common data for cars. The class also contains methods for driving a car.
 *
 * @author Arvid
 * @author Obada
 * @author Matilda
 */

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

    /**
     * Constructor that sets initial values, and stops the car's engine.
     *
     * @param nrDoors Number of doors
     * @param enginePower Engine power
     * @param color Color
     * @param modelName Model Name
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        x = 0;
        y = 0;
        orientation = Orientation.UP;
        stopEngine();
    }

    /**
     * Constructor without parameters
     */
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

    /**
     * Sets the car's speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the car's speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Abstract method that returns a factor used in determining how much the car's speed should increase or decrease
     * when the gas() and break() methods are called
     * @return the car's speed factor
     */
    protected abstract double speedFactor();


    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed>enginePower){
            currentSpeed=enginePower;
        }
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed<0){
            currentSpeed=0;
        }
    }

    /**
     * Method that changes car's x- and y position according to it's current speed and orientation
     */
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

    /**
     * Method that changes that changes the car's orientation depending on it's current orientation. It uses an array
     * of enums to get the "next" orientation.
     */
    public void turnLeft(){
        orientation=Orientation.values()[(orientation.ordinal()+1)%4];
    }

    /**
     * The same as turnLeft(), except it gets the previous value in the array
     */
    public void turnRight(){
        orientation=Orientation.values()[(orientation.ordinal()+3)%4];
    }

    /**
     * Method that increases the car's speed depending on amount. The car's speed can never exceed the engine power
     * @param amount, where amount lies in the interval [0,1]
     */
    public void gas(double amount){
        if (amount<0||amount>1){
            throw new IllegalArgumentException("Invalid amount");
        }
        incrementSpeed(amount);
    }

    /**
     * Method that decreases the car's speed depending on amount. The car's speed can never be less than zero
     * @param amount, where amount lies in the interval [0,1]
     */
    public void brake(double amount){
        if (amount<0||amount>1){
            throw new IllegalArgumentException();
        }
        decrementSpeed(amount);
    }



}
