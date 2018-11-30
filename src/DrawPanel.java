import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    java.util.List<Car> cars = new ArrayList<>();
    // To keep track of a singel cars position
    //Point volvoPoint = new Point();

    // TODO: Make this genereal for all cars
    /*void moveit(Point p, int x, int y){
        p.setX(x);
        p.setY(y);
    }*/

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;
        // Print an error message in case file is not found with a try/catch block
        /*try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car c : cars) {
            g.drawImage(c.getImage(), (int)c.getX(), (int)c.getY(), null); // see javadoc for more info on the parameters
        }
    }
}