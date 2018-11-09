import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @org.junit.jupiter.api.Test
    void gas() {

        Car car1 = new Saab95();
        car1.gas(1);
        assertEquals(1.25, car1.getCurrentSpeed());
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            car1.gas(5);
        });
        assertEquals("Invalid amount", exception.getMessage());
    }
}