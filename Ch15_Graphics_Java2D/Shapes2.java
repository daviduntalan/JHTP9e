package Ch15_Graphics_Java2D;
/** Fig. 15.32: Demonstrating a general path. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

/** Fig. 15.31: Demonstrating a general path */
class Shapes2JPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent
        Random random = new Random(); // get random number generator

        int[] xPoints = {55, 67, 109, 73, 83, 55, 27, 37,  1, 43};
        int[] yPoints = { 0, 36,  36, 54, 96, 72, 96, 54, 36, 36};

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
        GeneralPath star = new GeneralPath(); // create GeneralPath object

        // set the initial coordinate of the GeneralPath
        star.moveTo(xPoints[0], yPoints[0]);

        // create the star--this does not draw the star
        for (int count=1; count < xPoints.length; ++count) {
            star.lineTo(xPoints[count], yPoints[count]);
        }

        star.closePath(); // close the shape - completes the general path.

        g2d.setColor(Color.BLACK);
        g2d.fillRect(150, 150, 2, 2);

        g2d.translate(150, 150); // move the drawing origin to location (150,150)

        // rotate around origin and draw stars in random colors
        for (int count = 1; count <= 20; ++count) {
            g2d.rotate(Math.PI / 10 ); // rotate coordinate system
            // set random drawing color
            g2d.setColor(
                    new Color(
                            random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)
                    )
            );
            g2d.fill( star ); // draw filled star
        } // end for

    } // end of method paintComponent
} // end of class ShapesJPanel

public class Shapes2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Shapes2JPanel());
        frame.setBackground(Color.WHITE);
        frame.setSize(315,330);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}