package Ch15_Graphics_Java2D;
/** Fig. 15.28: Drawing polygons. */

import javax.swing.*;

public class DrawPolygons {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing Polygons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PolygonsJPanel()); // add PolygonsJPanel to frame
        frame.setSize(280, 270); // set frame size
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
