public abstract class Vehicle {

    private double currentSpeed;
    private Point position;
    private Orientation orientation;
    private double enginePower;
    private double weight;


    public Vehicle(double enginePower, double weight) {
        this.weight = weight;
        this.enginePower = enginePower;
        currentSpeed = 0;
        position = new Point(0, 0);
        orientation = Orientation.RIGHT;
    }

    /**
     * Returns the distance between two IMoveables.
     * @param c moveable to find distance to
     * @return the distance between the this and moveable
     */
    public double distance (Car c) {
        double dx = getX() - c.getX();
        double dy = getY() - c.getY();
        double d = Math.pow(dx, 2) + Math.pow(dy, 2);
        return Math.sqrt(d);
    }

    /**
     * Abstract method that returns a factor used in determining how much the car's speed should increase or decrease
     * when the gas() and break() methods are called
     * @return the moveable's speed factor
     */
    protected abstract double speedFactor();

    /**
     * Checks weather this is moving
     * @return true if this is moving, else false
     */
    public boolean isMoving() {
        return currentSpeed != 0;
    }

    private void incrementSpeed(double amount, double speedFactor){
        setCurrentSpeed(getCurrentSpeed() + speedFactor * amount);
        if (getCurrentSpeed()>enginePower){
            setCurrentSpeed(enginePower);
        }
    }

    private void decrementSpeed(double amount, double speedFactor){
        setCurrentSpeed(getCurrentSpeed() - speedFactor * amount);
        if (getCurrentSpeed()<0){
            setCurrentSpeed(0);
        }
    }

    /**
     * Method that changes moveable's x- and y position according to it's current speed and orientation
     */
    public void move(){
        switch (getOrientation()){
            case RIGHT:
                setX(getX()+getCurrentSpeed());
                break;
            case LEFT:
                setX(getX()-getCurrentSpeed());
                break;
            case UP:
                setY(getY()-getCurrentSpeed());
                break;
            case DOWN:
                setY(getY()+getCurrentSpeed());
                break;
        }
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Method that changes that changes the moveable's orientation depending on it's current orientation.
     */
    public void turnLeft(){
        orientation= Orientation.values()[(orientation.ordinal()+1)%4];
    }

    /**
     * Method that changes that changes the moveable's orientation depending on it's current orientation.
     */
    public void turnRight(){
        orientation= Orientation.values()[(orientation.ordinal()+3)%4];
    }

    /**
     * Method that increases the moveable's speed depending on amount. The car's speed can never exceed the engine power.
     * @param amount an amount of brake between 0 and 1
     */
    public void gas(double amount){
        gas(amount, 1);
    }

    /**
     * Method that increases the moveable's speed depending on amount and speed factor. The car's speed can never exceed the engine power.
     * @param amount an amount of brake between 0 and 1
     * @param speedFactor Gets speed factor from vehicle.
     */
    public void gas(double amount, double speedFactor) {
        if (amount<0||amount>1){
            throw new IllegalArgumentException("Invalid amount");
        }
        incrementSpeed(amount, speedFactor);
    }

    /**
     * Method that decreases the moveasble's speed depending on amount. The car's speed can never be less than zero.
     * @param amount an amount of brake between 0 and 1
     */
    public void brake(double amount){
        brake(amount, 1);
    }

    /**
     * Method that decreases the moveasble's speed depending on amount and speed factor. The car's speed can never be less than zero.
     * @param amount an amount of brake between 0 and 1
     * @param speedFactor Gets speed factor from vehicle.
     */
    public void brake(double amount, double speedFactor) {
        if (amount<0||amount>1){
            throw new IllegalArgumentException("Invalid amount");
        }
        decrementSpeed(amount, speedFactor);
    }

    /**
     * Gets position.
     * @return position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Sets position.
     * @param p new position
     */
    public void setPosition(Point p) {
        position = p;
    }

    /**
     * Gets current speed.
     * @return current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets new speed.
     * @param speed new speed
     */
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    /**
     * Gets moveable's orientation.
     * @return current orientation
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets orientation.
     * @param orientation new orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Gets current x-position.
     * @return current x-position
     */
    public double getX() {
        return position.getX();
    }

    /**
     * Sets x-position.
     * @param x new x-position
     */
    public void setX(double x) {
        position.setX(x);
    }

    /**
     * Gets current y-position.
     * @return current y-position
     */
    public double getY() {
        return position.getY();
    }

    /**
     * Sets y-position.
     * @param y new y-position
     */
    public void setY(double y) {
        position.setY(y);
    }

    /**
     * Gets the moveable's engine power.
     * @return engine power
     */
    public double getEnginePower() {
        return enginePower;
    }
}