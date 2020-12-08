package Ch15_Graphics_Java2D;
/** Concentric Circles using method drawArc.
 * Write an application that draws a series of eight concentric circles.
 * The circles should be separated by 10 pixels. Use Graphics method drawArc. */

import javax.swing.*;
import java.awt.*;

class ConcentricCircleJPanel extends  JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent

        g.setColor(Color.BLACK);

        int x = 10;
        int y = 50;
        int w = 80;
        int h = 80;
        for (int count = 1; count <= 8; ++count) {
            g.drawOval(x, y, w, h);
            g.fillOval(x, y+h+10, w, h/2);
            x += w + 10;
        }

    }
}

public class Ex15_06_ConcentricCircles {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Concentric Circles using method drawArc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ConcentricCircleJPanel()); // add ConcentricCircleJPanel to frame
        frame.setSize(750, 300); // set frame size
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
