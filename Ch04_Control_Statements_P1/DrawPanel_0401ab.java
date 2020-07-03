package Ch04_Control_Statements_P1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel_0401ab extends JPanel {

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
            g.drawLine(0, 0, xStep, h - yStep); /* origin: upper-left: lower-left to upper right */
            g.drawLine(w, 0, w - xStep, h - yStep); /* origin: upper-right: lower-right to upper-left */
            g.drawLine(w, h, xStep, h - yStep); /* origin: lower-right: lower-left to upper-right */ 
            g.drawLine(0, h, w - xStep, h - yStep); /* origin: lower-left: lower-right to upper-left */
            
            xStep += xGap;
            yStep += yGap;
            --lines;
        }
    }

}
