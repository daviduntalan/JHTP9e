package Ch15_Graphics_Java2D;
/** Random Triangles. Write an application that displays randomly generated triangles in different
 colors. Each triangle should be filled with a different color. Use class GeneralPath and method
 fill of class Graphics2D to draw the triangles. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.util.Random;

/** (Random Triangles) application that displays randomly generated triangles in different
 colors. Each triangle filled with a different color. Used class GeneralPath and method
 fill of class Graphics2D to draw the triangles. */
class RandomTriangles extends JPanel implements ActionListener {

    private Timer timer;

    public RandomTriangles() {
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        Random random = new Random(); // get random number generator

        int[] xPoints = {60, 120,  0};
        int[] yPoints = { 0, 100, 100};

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
        GeneralPath triangle = new GeneralPath(); // create GeneralPath object

        // set the initial coordinate of the GeneralPath
        triangle.moveTo(xPoints[0], yPoints[0]);

        // create the triangle--this does not draw the triangle
        for (int count=1; count < xPoints.length; ++count) {
            triangle.lineTo(xPoints[count], yPoints[count]);
        }

        triangle.closePath(); // close the shape - completes the general path.

        g2d.setColor(Color.BLACK);
        g2d.fillRect(200, 200, 2, 2);

        g2d.translate(200, 200); // move the drawing origin to location (150,150)

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
            g2d.fill( triangle ); // draw filled triangle
        } // end for

    } // end of method paintComponent

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
} // end of class ShapesJPanel

public class Ex15_09_RandomTriangles {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Random Triangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomTriangles());
        frame.setBackground(Color.WHITE);
        frame.setSize(400,420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}