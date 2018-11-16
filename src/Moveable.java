public class Moveable {

    private double currentSpeed;
    private Point position;
    private Orientation orientation;
    private double enginePower;


    public Moveable(double enginePower) {
        this.enginePower = enginePower;
        currentSpeed = 0;
        position = new Point(0, 0);
        orientation = Orientation.UP;
    }

    public double distance (IMoveable moveable) {
        double dx = getX()-moveable.getX();
        double dy = getY()-moveable.getY();
        double d = Math.pow(dx, 2) + Math.pow(dy, 2);
        return Math.sqrt(d);
    }

    /**
     * Abstract method that returns a factor used in determining how much the car's speed should increase or decrease
     * when the gas() and break() methods are called
     * @return the car's speed factor
     */
    protected double speedFactor() {
        return 1;
    }

    public boolean isMoving() {
        return currentSpeed != 0;
    }

    public void setPosition(Point p) {
        position = p;
    }

    public Point getPosition() {
        return position;
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        if (getCurrentSpeed()>enginePower){
            setCurrentSpeed(enginePower);
        }
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
        if (getCurrentSpeed()<0){
            setCurrentSpeed(0);
        }
    }

    /**
     * Method that changes car's x- and y position according to it's current speed and orientation
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
                setY(getY()+getCurrentSpeed());
                break;
            case DOWN:
                setY(getY()-getCurrentSpeed());
                break;
        }
    }

    /**
     * Method that changes that changes the car's orientation depending on it's current orientation. It uses an array
     * of enums to get the "next" orientation.
     */
    public void turnLeft(){
        orientation= Orientation.values()[(orientation.ordinal()+1)%4];
    }

    /**
     * The same as turnLeft(), except it gets the previous value in the array (3=-1)%4
     */
    public void turnRight(){
        orientation= Orientation.values()[(orientation.ordinal()+3)%4];
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
            throw new IllegalArgumentException("Invalid amount");
        }
        decrementSpeed(amount);
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setX(double x) {
        position.setX(x);
    }

    public void setY(double y) {
        position.setY(y);
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public double getEnginePower() {
        return enginePower;
    }
}
