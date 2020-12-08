package Ch15_Graphics_Java2D;
/** Concentric Circles using Ellipse2D.Double.
 * Modify your solution to Exercise 15.6 to draw the ovals by using
 * class Ellipse2D.Double and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class ConcentricCirclesEllipse2D extends  JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);

        int x = 10;
        int y = 50;
        int w = 80;
        int h = 80;

        for (int count = 1; count <= 8; ++count) {
            g2d.draw(new Ellipse2D.Double(x, y, w, h));
            g.fillOval(x, y+h+10, w, h/2);
            x += w + 10;
        }

    }
}

public class Ex15_07_ConcentricCirclesEllipse2D {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Concentric Circles using Ellipse2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ConcentricCirclesEllipse2D()); // add ConcentricCircleJPanel to frame
        frame.setSize(750, 300); // set frame size
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
