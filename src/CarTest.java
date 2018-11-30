import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carMethodsTest() {
        Saab95 car = new Saab95(0, 0);
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());

        car.move();
        assertEquals(0.1, car.getY());
        assertEquals(0, car.getX());

        car.turnRight();
        car.turnRight();
        assertEquals(Orientation.DOWN, car.getOrientation());

        car.turnLeft();
        assertEquals(Orientation.RIGHT, car.getOrientation());

        car.gas(1);
        assertEquals(1.35, car.getCurrentSpeed());
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            car.gas(5);;
        });
        assertEquals("Invalid amount", exception.getMessage());

        car.setTurboOn();
        car.gas(1);
        assertEquals(2.975, car.getCurrentSpeed());
        car.setTurboOff();


        car.brake(1);
        assertEquals(1.725, car.getCurrentSpeed());

        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());

        Volvo240 volvo = new Volvo240(0, 0);
        volvo.startEngine();
        volvo.gas(1);
        assertEquals(1.35, volvo.getCurrentSpeed());
    }

    @Test
    void scaniaMethodsTest() {
        Scania scania = new Scania(0, 0);

        scania.tiltUp();
        assertEquals(10, scania.getAngle());

        scania.tiltUp();
        scania.tiltUp();
        scania.tiltUp();
        scania.tiltUp();
        scania.tiltUp();
        scania.tiltUp();
        assertEquals(70, scania.getAngle());
        scania.tiltUp();
        assertEquals(70, scania.getAngle());

        scania.tiltDown();
        assertEquals(60, scania.getAngle());

        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());

        scania.tiltDown();
        scania.tiltDown();
        scania.tiltDown();
        scania.tiltDown();
        scania.tiltDown();
        scania.tiltDown();

        scania.startEngine();
        scania.gas(1);
        assertEquals(1.1, scania.getCurrentSpeed());

        scania.tiltUp();
    }

    @Test
    void ferryMethodsTest() {
        Ferry ferry = new Ferry();
        Car car1 = new Volvo240(0, 0);

        ferry.tiltDown();
        ferry.load(car1);
        assertEquals(car1, ferry.getCars().get(0));

        for (int i = 0; i < 50; i++) {
            ferry.load(new Volvo240(0, 0));
        }

        assertEquals(50, ferry.getCars().size());

        for (int i = 0; i < 55; i++) {
            ferry.unload();
        }

        for (int i = 0; i < 50; i++) {
            ferry.load(new Scania(0, 0));
        }

        assertEquals(19, ferry.getCars().size());

        ferry.gas(1);
        assertEquals(1, ferry.getCurrentSpeed());

        ferry.move();
        assertEquals(1, ferry.getY());

        ferry.turnLeft();
        ferry.turnLeft();
        assertEquals(Orientation.DOWN, ferry.getOrientation());

        ferry.turnRight();
        ferry.turnRight();
        assertEquals(Orientation.UP, ferry.getOrientation());

        ferry.brake(1);
        assertEquals(0, ferry.getCurrentSpeed());
    }


    @Test
    void carTransportsMethod(){

        CarTransport cart = new CarTransport(0, 0);
       cart.tiltDown();
        for (int i = 0; i < 11; i++) {
            cart.load(new Volvo240(0, 0));
        }
        assertEquals(10,cart.getCars().size());

        cart.unload();
        cart.load(new Scania(0, 0));

        assertEquals(9,cart.getCars().size());

        cart.unload();
        Volvo240 v = new Volvo240(0, 0);
        v.setPosition(new Point(50, 50));
        assertFalse(cart.load(v));

        cart.gas(1);
        cart.move();
        assertEquals(cart.getPosition(), cart.getCars().get(0).getPosition());

        Car c = cart.unload();
        cart.move();
        assertTrue(cart.getPosition() != c.getPosition());


        cart.tiltUp();
        assertFalse(cart.isRampOpen());
    }



}