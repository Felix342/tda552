import java.util.ArrayList;
import java.util.List;

class Transport implements ITransport, ITiltable {
    private boolean rampOpen;
    private final int maxCars;
    private final double maxWeight;
    private final List<Car> cars = new ArrayList<>();

    public Transport(int maxCars, double maxWeight, Vehicle parentVehicle) {
        this.rampOpen = false;
        this.maxCars = maxCars;
        this.maxWeight = maxWeight;
    }

    @Override
    public void tiltUp() {
        rampOpen = false;
    }

    @Override
    public void tiltDown() {
        rampOpen = true;
    }

    /**
     * Loads a car if possible.
     * @param c the car to be loaded.
     * @return true if the car could be loaded, false otherwise.
     */
    @Override
    public boolean load(Car c) {
        if (rampOpen && cars.size() < maxCars && getCargoWeight() + c.getWeight() <= maxWeight  && !c.isLoaded()) {
            c.setLoaded(true);
            return cars.add(c);
        }
        return false;
    }

    @Override
    public Car unload() {
        return null;
    }

    /**
     * Calculates the weight of the loaded cars.
     * @return the weight of the loaded cars.
     */
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
