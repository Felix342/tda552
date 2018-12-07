import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    private static final int CAR_WIDTH = 100;
    private static final int CAR_HEIGHT = 60;

    //methods:

    public CarController() {
        cars.add(CarFactory.createSaab95(0, 0));
        cars.add(CarFactory.createVolvo240(0, 100));
        cars.add(CarFactory.createScania(0, 200));

    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (shouldTurn(car)) {
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                }
                car.move();
                /*int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y);*/
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private boolean shouldTurn(Car car) {
        return  ((car.getX()<0 && car.getOrientation()==Orientation.LEFT)||
                (car.getX()>=frame.drawPanel.getWidth() - CAR_WIDTH && car.getOrientation()==Orientation.RIGHT)||
                (car.getY()<0 && car.getOrientation()==Orientation.UP)||
                (car.getY()>=frame.drawPanel.getHeight() - CAR_HEIGHT && car.getOrientation()==Orientation.DOWN)
        );
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