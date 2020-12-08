package Ch15_Graphics_Java2D;
/** (Drawing Tetrahedrons)
 * Write an application that draws a tetrahedron (a three-dimensional shape with
 * four triangular faces). Use class GeneralPath and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

class Tetrahedrons extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        Random random = new Random(); // get random number generator

        int[] xPoints = {60, 120,   0, 60, 30, 90, 60, 30};
        int[] yPoints = { 0, 100, 100,  0, 50, 50, 100, 50};

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
        GeneralPath tetrahedron = new GeneralPath(); // create GeneralPath object

        // set the initial coordinate of the GeneralPath
        tetrahedron.moveTo(xPoints[0], yPoints[0]);

        // create the tetrahedron--this does not draw the tetrahedron
        for (int count=1; count < xPoints.length; ++count) {
            tetrahedron.lineTo(xPoints[count], yPoints[count]);
        }

        tetrahedron.closePath(); // close the shape - completes the general path.

        g2d.setColor(Color.BLACK);
        g2d.fillRect(200, 200, 2, 2);

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
            g2d.fill( tetrahedron ); // draw filled tetrahedron

            g2d.setColor(Color.BLACK);
            g2d.draw( tetrahedron ); // draw skeleton of tetrahedron
        } // end for
    } // end of method paintComponent
} // end of class ShapesJPanel

public class Ex15_15_Tetrahedrons {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing Tetrahedrons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Tetrahedrons()); // add ConcentricCircleJPanel to frame
        frame.setSize(400, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
