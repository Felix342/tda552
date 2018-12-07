import java.awt.*;
import java.util.List;

public class CarTransport extends Car implements ITiltable, ITransport{
    private Transport parentTransport;

    public CarTransport(double x, double y){
        super(2, 100, 2500, Color.BLUE, "Car Transport 1", x, y);
        parentTransport = new Transport(10, 20000, this);
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
        if (!isMoving()) {
            parentTransport.tiltDown();
        }
    }

    public boolean load(Car car) {
        if( distance(car) <= 2){
            car.setPosition(getPosition());
            return parentTransport.load(car);
        }else {
            return false;
        }
    }

    /**
     * Checks if the ramp is open and weather there are any cars that can be unloaded. If there are, the car that
     * was loaded latest is unloaded.
     * @return the unloaded car
     */
    public Car unload() {
        if (parentTransport.isRampOpen() && !getCars().isEmpty()) {
            Car car = getCars().get(getCars().size()-1);
            getCars().remove(getCars().size()-1);
            car.setPosition(new Point(getX(), getY()));
            car.setLoaded(false);
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

    @Override
    protected double speedFactor() {
        return 1;
    }
}
