package Ch15_Graphics_Java2D;
/** (Drawing Cubes) Write an application that draws a cube.
 * Use class GeneralPath and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

class Cubes extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        Random random = new Random(); // get random number generator

        // use PaintBrush to help you find the points
        int[] xPoints = { 0, 75, 150, 75,  0,  0,  75, 150, 150, 75, 75,  0, 75, 150};
        int[] yPoints = {30,  0,  30, 60, 30,110, 140, 110,  30, 60,140,110, 75, 110};

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
        GeneralPath cube = new GeneralPath(); // create GeneralPath object

        // set the initial coordinate of the GeneralPath
        cube.moveTo(xPoints[0], yPoints[0]);

        // create the tetrahedron--this does not draw the tetrahedron
        for (int count=1; count < xPoints.length; ++count) {
            cube.lineTo(xPoints[count], yPoints[count]);
        }

        // cube.closePath(); // close the shape - completes the general path.
        g2d.translate(200, 200); // move the drawing origin to location (150,150)

        // rotate around origin and draw stars in random colors
        for (int count = 1; count <= 20; ++count) {
            g2d.rotate(Math.PI / 2 ); // rotate coordinate system

            // set random drawing color
            g2d.setColor(
                    new Color(
                            random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)
                    )
            );
            g2d.fill( cube ); // draw filled tetrahedron

            g2d.setColor(Color.BLACK);
            g2d.draw( cube ); // draw skeleton of tetrahedron
        } // end for
    } // end of method paintComponent
} // end of class ShapesJPanel

public class Ex15_16_Cubes {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing Cubes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cubes()); // add ConcentricCircleJPanel to frame
        frame.setSize(400, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
