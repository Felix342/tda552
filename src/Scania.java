import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Scania extends Car implements ITiltable {
    private double angle;

    public Scania(double x, double y){
        super(2, 100, 5001, Color.RED, "Scania", x, y);
        try {
            setImage(ImageIO.read(new File("src\\pics\\Scania.jpg")));
        } catch (IOException e) {

        }
        angle = 0;
    }

    private double getTiltFactor() {
        return 10;
    }

    public void tiltUp() {
        if (!isMoving()) {
            System.out.println("up");
            this.angle += getTiltFactor();
            if (this.angle > 70) {
                this.angle = 70;
            }
        }
    }

    public void tiltDown() {
        if (!isMoving()) {
            System.out.println("down");
            this.angle -= getTiltFactor();
            if (this.angle < 0) {
                this.angle = 0;
            }
        }
    }

    @Override
    protected double speedFactor() {
        return 1;
    }

    @Override
    public void gas(double amount) {
        if (angle == 0) {
            super.gas(amount);
        }
    }

    @Override
    public void startEngine() {
        if (angle == 0) {
            super.startEngine();
        }
    }

    public double getAngle() {
        return angle;
    }
}
