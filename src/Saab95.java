import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Standard values for a Saab95
     */
    public Saab95(double x, double y){
        super(2, 125, 2000, Color.RED, "Saab95", x, y);
        try {
            setImage(ImageIO.read(new File("src\\pics\\Saab95.jpg")));
        } catch (IOException e) {

        }
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
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 2;
        return getEnginePower() * 0.01 * turbo;
    }

}