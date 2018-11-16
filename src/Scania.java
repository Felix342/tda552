import java.awt.*;

public class Scania extends Car implements ITiltable {
    private double angle;

    public Scania(){
        super(2, 100, 1800, Color.RED, "Scania");
        angle = 0;
    }

    private double getTiltFactor() {
        return 10;
    }

    public void tiltUp() {
        if (getCurrentSpeed() == 0) {
            this.angle += getTiltFactor();
            if (this.angle > 70) {
                this.angle = 70;
            }
        }
    }

    public void tiltDown() {
        this.angle -= getTiltFactor();
        if (this.angle < 0) {
            this.angle = 0;
        }
    }

    @Override
    public void gas(double amount) {
        if (angle == 0) {
            super.gas(amount);
        }
    }

    public double getAngle() {
        return angle;
    }
}
