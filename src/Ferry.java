import java.util.ArrayList;
import java.util.List;

public class Ferry implements IMoveable, ITiltable, ITransport {
    private Transport parentTransport;
    private Moveable parentMoveable;

    public Ferry() {
        parentMoveable = new Moveable(100);
        this.parentTransport = new Transport(50, 100000, parentMoveable);
    }

    @Override
    public void move() {
        parentMoveable.move();
    }

    /**
     * Method that changes that changes the car's orientation depending on it's current orientation. It uses an array
     * of enums to get the "next" orientation.
     */
    public void turnLeft(){
        parentMoveable.turnLeft();
    }

    /**
     * The same as turnLeft(), except it gets the previous value in the array (3=-1)%4
     */
    public void turnRight(){
        parentMoveable.turnRight();
    }

    @Override
    public boolean isMoving() {
        return parentMoveable.isMoving();
    }

    @Override
    public double getCurrentSpeed() {
        return parentMoveable.getCurrentSpeed();
    }

    @Override
    public double speedFactor() {
        return parentMoveable.speedFactor();
    }

    @Override
    public double getX() {
        return getPosition().getX();
    }

    @Override
    public double getY() {
        return getPosition().getY();
    }

    @Override
    public void setPosition(Point p) {
        parentMoveable.setPosition(p);
    }

    @Override
    public Point getPosition() {
        return parentMoveable.getPosition();
    }

    public boolean isRampOpen() {
        return parentTransport.isRampOpen();
    }

    @Override
    public void tiltUp() {
        parentTransport.tiltUp();
    }

    @Override
    public void tiltDown() {
        parentTransport.tiltDown();
    }

    public boolean load(Car car) {
        return parentTransport.load(car);
    }

    @Override
    public Car unload() {
        if (parentTransport.isRampOpen() && !getCars().isEmpty()) {
            Car car = getCars().remove(0);
            car.setPosition(new Point(getX(), getY()));
            return car;
        }
        return null;
    }

    public double getCargoWeight() {
        return parentTransport.getCargoWeight();
    }

    @Override
    public double getMaxCars() {
        return parentTransport.getMaxCars();
    }

    @Override
    public double getMaxWeight() {
        return parentTransport.getMaxWeight();
    }

    public List<Car> getCars() {
        return parentTransport.getCars();
    }
}
