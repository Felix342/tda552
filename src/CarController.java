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

    static CarModel model = new CarModel();
    //methods:

    public CarController(){
        // Instance of this class
       // CarModel cm = new CarModel();

        // Start a new view and send a reference of self
        model.frame = new CarView("CarSim 1.0", model);

        // Start the timer
        this.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
                /*int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y);*/
                // repaint() calls the paintComponent method of the panel
            model.frame.drawPanel.repaint();
        }
    }

    private boolean shouldTurn(Car car) {
        return  model.shouldTurn(car);
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        model.gas(amount);
    }

    void brake(int amount) {
        model.brake(amount);
    }

    void turboOn() {
        model.turboOn();
    }

    void turboOff() {
        model.turboOff();
    }

    void liftBed() {
        model.liftBed();
    }

    void lowerBed() {
        model.lowerBed();
    }

    void startAll() {
        model.startAll();
    }

    void stopAll() {
        model.stopAll();
    }


}