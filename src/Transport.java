import java.util.ArrayList;
import java.util.List;

class Transport implements ITransport, ITiltable {
    private boolean rampOpen;
    private final int maxCars;
    private final double maxWeight;
    private final List<Car> cars = new ArrayList<>();
    private final Moveable parentMoveable;

    public Transport(int maxCars, double maxWeight, Moveable parentMoveable) {
        this.rampOpen = false;
        this.maxCars = maxCars;
        this.maxWeight = maxWeight;
        this.parentMoveable = parentMoveable;
    }

    @Override
    public void tiltUp() {
        rampOpen = false;
    }

    @Override
    public void tiltDown() {
        if (!parentMoveable.isMoving()) {
            rampOpen = true;
        }
    }

    @Override
    public boolean load(Car c) {
        if (rampOpen && parentMoveable.distance(c) <= 2 && cars.size() < maxCars && getCargoWeight() + c.getWeight() <= maxWeight &&
                c.parentMoveable != parentMoveable) {
            c.setPosition(parentMoveable.getPosition());
            return cars.add(c);
        }
        return false;
    }

    @Override
    public Car unload() {
        return null;
    }

    @Override
    public double getCargoWeight() {
        double sum = 0;
        for (Car c : cars) {
            sum += c.getWeight();
        }
        return sum;
    }

    @Override
    public double getMaxCars() {
        return maxCars;
    }

    @Override
    public double getMaxWeight() {
        return maxWeight;
    }

    public void setRampOpen(boolean rampOpen) {
        this.rampOpen = rampOpen;
    }

    public boolean isRampOpen() {
        return rampOpen;
    }

    public List<Car> getCars() {
        return cars;
    }
}
