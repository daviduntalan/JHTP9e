package Ch15_Graphics_Java2D;
/** (Grid Using Class Rectangle2D.Double)
 * Modify your solution to Exercise 15.13 to draw the grid by using class
 * Rectangle2D.Double and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

class GridUsingRectangle2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        g.setColor(Color.LIGHT_GRAY);
        Graphics2D g2d = (Graphics2D) g;
        int x2 = this.getWidth();
        int y2 = this.getHeight();
        for (int x = 0; x < x2; x += 12) {
            for (int y = 0; y < y2; y += 12) {
                g2d.draw(new Rectangle2D.Double(x, y, 10, 10)); // draw 10x10 rectangle
            }
        }
    }
}

public class Ex15_14_Grid_Rectangle2D {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid Using class Rectangle2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridUsingRectangle2D()); // add ConcentricCircleJPanel to frame
        frame.setSize(600, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
