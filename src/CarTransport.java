import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Car implements ITiltable, ITransport, IMoveable{
    private Transport parentTransport;

    public CarTransport(double x, double y){
        super(2, 100, 2500, Color.BLUE, "Car Transport 1", x, y);
        parentTransport = new Transport(10, 20000, parentMoveable);
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
}
