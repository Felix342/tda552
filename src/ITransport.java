/**
 * Methods that handle loading/unlosding of cars
 */

public interface ITransport {
    boolean load(Car c);

    Car unload();

    double getCargoWeight();

    double getMaxCars();

    double getMaxWeight();
}
