import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Car implements ITiltable, ITransport{
    private Transport parentTransport;

    public CarTransport(){
        super(2, 100, 2500, Color.BLUE, "Car Transport 1");
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

    public Car unload() {
        if (parentTransport.isRampOpen() && !getCars().isEmpty()) {
            Car car = getCars().get(getCars().size()-1);
            getCars().remove(getCars().size()-1);
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
