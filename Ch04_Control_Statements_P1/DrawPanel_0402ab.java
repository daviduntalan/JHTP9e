package Ch04_Control_Statements_P1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel_0402ab extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        setBackground(Color.black);
        setForeground(Color.green);

        int w = getWidth() - 1; // total width
        int h = getHeight() - 1; // total height

        int lines = 15;
        int xStep = 0, yStep = 0;
        int xGap = w / lines;
        int yGap = h / lines;

        while (lines > 0) {
            g.drawLine(0, yStep, xStep, h); // lower-left
            g.drawLine(0, h - yStep, xStep, 0); // upper-left
            g.drawLine(xStep, 0, w, yStep); // upper-right
            g.drawLine(w, yStep, w - xStep, h); // lower-right
            xStep += xGap;
            yStep += yGap;
            --lines;
        }
    }

}
