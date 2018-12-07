import java.util.ArrayList;

public class CarModel {

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    private static final int CAR_WIDTH = 100;
    private static final int CAR_HEIGHT = 60;

    ArrayList<Car> cars = new ArrayList<>();

    public CarModel(){
        cars.add(new Volvo240(0, 0));
        cars.add(new Saab95(0, 100));
        cars.add(new Scania(0, 200));
    }

    public boolean shouldTurn(Car car) {
        return  ((car.getX()<0 && car.getOrientation()==Orientation.LEFT)||
                (car.getX()>=frame.drawPanel.getWidth() - CAR_WIDTH && car.getOrientation()==Orientation.RIGHT)||
                (car.getY()<0 && car.getOrientation()==Orientation.UP)||
                (car.getY()>=frame.drawPanel.getHeight() - CAR_HEIGHT && car.getOrientation()==Orientation.DOWN)
        );
    }

    void turnIfAppropriate(Car car){
        if (shouldTurn(car)) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine();
        }
    }

    void update(){
        for (Car car : cars) {
            turnIfAppropriate(car);
            car.move();
        }


    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car c : cars) {
            if (c instanceof ITiltable) {
                ((ITiltable) c).tiltUp();
            }
        }
    }

    void lowerBed() {
        for (Car c : cars) {
            if (c instanceof ITiltable) {
                ((ITiltable) c).tiltDown();
            }
        }
    }

    void startAll() {
        for (Car c : cars) {
            c.startEngine();
        }
    }

    void stopAll() {
        for (Car c : cars) {
            c.stopEngine();
        }
    }

}
