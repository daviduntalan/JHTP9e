package Ch15_Graphics_Java2D;

import javax.swing.*;

/** Fig. 15.12: Using fonts. */
public class Fonts {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Using Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new FontJPanel() ); // add FontJPanel to frame
        frame.setSize(420, 150);
        frame.setVisible(true); // display frame
    }
}
