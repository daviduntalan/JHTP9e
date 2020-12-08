package Ch15_Graphics_Java2D;
/** (Grid Using Class Line2D.Double) Modify your solution to Exercise 15.11 to draw the
 grid using instances of class Line2D.Double and method draw of class Graphics2D. */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

class GridUsingLine2D extends  JPanel {

    private final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g); // call super class's paintComponent
        g.setColor(Color.LIGHT_GRAY);
        Graphics2D g2d = (Graphics2D) g;
        int x1 = 0;
        int y1 = 0;
        int x2 = this.getWidth();
        int y2 = this.getHeight();
        for(int x = 8; x < x2; x+=8) g2d.draw(new Line2D.Double(x, y1, x, y2)); // draw y-axis
        for(int y = 8; y < y2; y+=8) g2d.draw(new Line2D.Double(x1, y, x2, y)); // draw x-axis
    }
}

public class Ex15_12_Grid_Line2D {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid using class Line2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridUsingLine2D()); // add ConcentricCircleJPanel to frame
        frame.setSize(600, 400); // set frame size
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
