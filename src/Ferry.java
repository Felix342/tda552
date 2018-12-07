import java.util.List;

public class Ferry extends Vehicle implements ITiltable, ITransport {
    private Transport parentTransport;

    public Ferry() {
        super(100, 200);
        this.parentTransport = new Transport(50, 100000, this);
    }

    @Override
    protected double speedFactor() {
        return 1;
    }

    @Override
    public double getX() {
        return getPosition().getX();
    }

    @Override
    public double getY() {
        return getPosition().getY();
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

    @Override
    public Car unload() {
        if (parentTransport.isRampOpen() && !getCars().isEmpty()) {
            Car car = getCars().remove(0);
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
