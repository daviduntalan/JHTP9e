package Ch07_Arrays_and_ArrayLists;

import javax.swing.JFrame;

/**
 * Fig. 7.26: Test application to display a rainbow.
 * @author David
 */
public class DrawRainbowTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DrawRainbow panel = new DrawRainbow();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add Rainbow panel to frame
        frame.setSize(400, 250+22);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
