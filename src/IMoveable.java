
/**
 * All movables need to be able to move, turn right and turn left.
 */
public interface IMoveable {

    void move();

    void turnRight();

    void turnLeft();

    boolean isMoving();

    double getCurrentSpeed();

    double speedFactor();

    double getX();

    double getY();

    void setPosition(Point p);

    Point getPosition();
}
