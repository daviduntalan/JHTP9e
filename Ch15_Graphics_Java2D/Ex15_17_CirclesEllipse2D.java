package Ch15_Graphics_Java2D;
/** (Drawing Cubes) Write an application that draws a cube.
 * Use class GeneralPath and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class CirclesEllipse2D extends JPanel {

    public void paintComponent(Graphics g) {
        // super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

        float radius = 100.0f;
        float diameter = 2.0f * radius;
        float circumference = (float) (2.0f * Math.PI * radius);
        float area = (float) (Math.PI * (radius * radius));

        double x = (getWidth() - diameter) / 2; // center x-axis
        double y = (getHeight() - diameter) / 2; // center y-axis
        double w = diameter; double h = diameter;

        g2d.setPaint(Color.RED);
        g2d.fill(new Ellipse2D.Double(x, y, w, h));

        g2d.setColor(Color.BLACK);
        g2d.draw(new Ellipse2D.Double(x, y, w, h));

        g2d.drawString(String.format("Circumference: %f", circumference), 10, 20);
        g2d.drawString(String.format("Diameter: %f", diameter), 10, 40);
        g2d.drawString(String.format("Area: %f", area), 10, 60);
    }
}

public class Ex15_17_CirclesEllipse2D {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Circles using class Ellipse2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CirclesEllipse2D()); // add ConcentricCircleJPanel to frame
        frame.setSize(400, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
