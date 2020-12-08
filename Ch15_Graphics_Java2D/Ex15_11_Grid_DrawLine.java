package Ch15_Graphics_Java2D;
/** Grid Using Method drawLine)
 * Write an application that draws an 8-by-8 grid.
 * Use Graphics method drawLine. */

import javax.swing.*;
import java.awt.*;

class GridUsingDrawLine extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        g.setColor(Color.LIGHT_GRAY);

        int x1 = 0;
        int y1 = 0;
        int x2 = this.getWidth();
        int y2 = this.getHeight();
        for(int x = 8; x < x2; x+=8) g.drawLine(x, y1, x, y2); // draw y-axis
        for(int y = 8; y < y2; y+=8) g.drawLine(x1, y, x2, y); // draw x-axis
    }
}

public class Ex15_11_Grid_DrawLine {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid Using Method drawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridUsingDrawLine()); // add ConcentricCircleJPanel to frame
        frame.setSize(600, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
