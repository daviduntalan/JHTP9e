package Ch15_Graphics_Java2D;

import javax.swing.*;

/** Fig. Drawing lines, rectangles and ovals. */
public class LinesRectsOvals {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing lines, rectangles and ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new LinesRectsOvalsJPanel() ); // add LinesRectsOvalsJPanel to frame
        frame.setSize(400, 210);
        frame.setVisible(true); // display frame
    }
}
