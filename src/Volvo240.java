import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Standard values for a Volvo240.
     */
    public Volvo240(){
        super(4, 100, 1700, Color.BLACK, "Volvo240");
    }

    /**
     * Method that determines the speed factor depending on the trim factor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}