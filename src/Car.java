import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class containing common data for cars. The class also contains methods for driving a car.
 *
 * @author Arvid
 * @author Obada
 * @author Matilda
 */

public abstract class Car extends Vehicle {

    private int nrDoors;
    private Color color;
    private String modelName;
    private boolean loaded = false;
    private BufferedImage image;

    /**
     * Constructor that sets initial values, and stops the car's engine.
     *
     * @param nrDoors Number of doors
     * @param enginePower Engine power
     * @param color Color
     * @param modelName Model Name
     */
    public Car(int nrDoors, double enginePower, double weight, Color color, String modelName, double x, double y) {
        super(enginePower, weight);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        setX(x);
        setY(y);
        stopEngine();
        this.getEnginePower();
    }


    /**
     * Constructor without parameters
     */
    public Car(){
        this(0, 0, 0, null, null, 0, 0);
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    public double getX() {
        return getPosition().getX();
    }

    public double getY() {
        return getPosition().getY();
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Sets the car's speed to 0.1
     */
    public void startEngine(){
        if(!loaded) {
            setCurrentSpeed(0.1);
        }
    }

    /**
     * Sets the car's speed to 0
     */
    public void stopEngine(){
        setCurrentSpeed(0);
    }


    /**
     * Method that changes car's x- and y position according to it's current speed and orientation
     */
    public void move(){
        if (!loaded) {
            super.move();
        }
    }

    /**
     * Method that changes that changes the car's orientation depending on it's current orientation. It uses an array
     * of enums to get the "next" orientation.
     */
    public void turnLeft(){
        if (!loaded) {
            super.turnLeft();
        }
    }

    /**
     * The same as turnLeft(), except it gets the previous value in the array (3=-1)%4
     */
    public void turnRight(){
        if (!loaded) {
            super.turnRight();
        }
    }

    /**
     * Method that increases the car's speed depending on amount. The car's speed can never exceed the engine power
     * @param amount, where amount lies in the interval [0,1]
     */
    public void gas(double amount){
        if (!loaded) {
            gas(amount, speedFactor());
        }
    }

    /**
     * Method that decreases the car's speed depending on amount. The car's speed can never be less than zero
     * @param amount, where amount lies in the interval [0,1]
     */
    public void brake(double amount){
        brake(amount, speedFactor());
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}