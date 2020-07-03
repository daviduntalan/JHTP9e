package Ch05_Control_Statements_P2;

import javax.swing.JFrame;

/**
 * Test application that displays class Shapes. Fig. 5.28
 *
 * @author David
 */
public class ShapesCircleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the panel with the user's input
        ShapesCircle panel = new ShapesCircle(10);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add the panel to the frame
        frame.setSize(300, 300 + 22); // set the desired size
        frame.setLocationRelativeTo(null); // center position
        frame.setVisible(true); // show the frame
    }

}
