package Ch15_Graphics_Java2D;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/** Fig. 15.24 Drawing arcs. */
public class ArcsJPanel extends  JPanel {

    // draw rectangles and arcs

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent

        // start at 0 and sweep 360 degrees (draw counter-clockwise)
        g.setColor(Color.RED);
        g.drawRect(15, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(15, 35, 80, 80, 0, 360);

        // start at 0 and sweep 110 degrees (draw counter-clockwise)
        g.setColor(Color.RED);
        g.drawRect(100, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(100, 35, 80, 80, 0, 110);

        // start at 0 and sweep -270 degrees (draw clockwise)
        g.setColor(Color.RED);
        g.drawRect(185, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(185, 35, 80, 80, 0, -270);

        // start at 0 and sweep 360 degrees (draw counter-clockwise)
        g.fillArc(15, 120, 80, 40, 0, 360);

        // start at 270 and sweep -90 degrees (draw clockwise)
        g.fillArc(100, 120, 80, 40, 270, -90);

        // start at 0 and sweep -270 degrees (draw clockwise)
        g.fillArc(185, 120, 80, 40, 0, -270);
    }
}
