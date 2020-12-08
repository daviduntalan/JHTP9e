package Ch15_Graphics_Java2D;
/** Concentric Circles using Ellipse2D.Double.
 * Modify your solution to Exercise 15.6 to draw the ovals by using
 * class Ellipse2D.Double and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

class RandomLinesLine2D extends  JPanel {

    private final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);

        int x = 10;
        int y = 50;
        int w = 80;
        int h = 180;

        Random random = new Random();
        for (int count = 1; count <= 8; ++count) {
            g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            g2d.setPaint(colors[random.nextInt(colors.length)]);
            g2d.draw(new Line2D.Double(x, y, x+w, h));
            g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.draw(new Line2D.Double(x+w, y, x, h));
            x += w + 10;
        }

    }
}

public class Ex15_08_RandomLinesLine2D {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Random Lines using class Line2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomLinesLine2D()); // add ConcentricCircleJPanel to frame
        frame.setSize(750, 300); // set frame size
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
