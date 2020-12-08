package Ch15_Graphics_Java2D;
/** (Grid Using Method drawRect)
 * Write an application that draws a 10-by-10 grid.
 * Use the Graphics method drawRect. */

import javax.swing.*;
import java.awt.*;
class GridUsingDrawRect extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        g.setColor(Color.LIGHT_GRAY);

        int x2 = this.getWidth();
        int y2 = this.getHeight();
        for (int x = 0; x < x2; x += 12) {
            for (int y = 0; y < y2; y += 12) {
                g.drawRect(x, y, 10, 10); // draw 10x10 rectangle
            }
        }
    }
}

public class Ex15_13_Grid_DrawRect {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid Using Method drawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridUsingDrawRect()); // add ConcentricCircleJPanel to frame
        frame.setSize(600, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
