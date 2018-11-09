import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Standard values for a Saab95
     */
    public Saab95(){
        super(2, 125, Color.RED, "Saab95");
        turboOn = false;
    }

    /**
     * Method that enables the turbo
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Method that disables the turbo
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Method that determines the speed factor depending on whether the turbo is on or off
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}