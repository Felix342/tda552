import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Standard values for a Volvo240.
     */
    public Volvo240(double x, double y){
        super(4, 125, 1700, Color.BLACK, "Volvo240", x, y);
        try {
            setImage(ImageIO.read(new File("src\\pics\\Volvo240.jpg")));
        } catch (IOException e) {

        }

    }

    /**
     * Method that determines the speed factor depending on the trim factor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}