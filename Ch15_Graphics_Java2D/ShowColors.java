package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;

/** Fig. 15.6: Demonstrating Colors. */
public class ShowColors {

    public static void main(String[] args) {

        // create frame for ColorJPanel
        JFrame frame = new JFrame("Using Colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ColorJPanel colorJPanel = new ColorJPanel(); // create ColorJPanel
        frame.add( colorJPanel ); // add colorJPanel to frame
        frame.setSize(400, 180); // set frame size
        frame.setVisible(true); // display frame
        frame.setLocationRelativeTo(null);
    }
}
