package Ch05_Control_Statements_P2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Test application that displays class Shapes.
 * Fig. 5.27
 * @author David
 */
public class ShapesTest {   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // obtain user's chocie
        String input = JOptionPane.showInputDialog(
            "Enter 1 to draw rectangles\n" +
            "Enter 2 to draw ovals");
        
        int choice = Integer.parseInt(input); // convert input to int
        
        // create the panel with the user's input
        Shapes panel = new Shapes(choice);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add the panel to the frame
        frame.setSize(300,300); // set the desired size
        frame.setLocationRelativeTo(null); // center position
        frame.setVisible(true); // show the frame
    }
    
}
