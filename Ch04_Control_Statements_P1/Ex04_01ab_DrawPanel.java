package Ch04_Control_Statements_P1;

import javax.swing.JFrame;

/**
 * Application to display a DrawPanel. 
 * @author David
 */
public class Ex04_01ab_DrawPanel {

    public static void main(String[] args) {
        // create a panel that contains our drawing
        DrawPanel_0401ab panel = new DrawPanel_0401ab();
        
        // create a new frame to hold the panel
        JFrame frame = new JFrame();
        
        // set the frame to exit when it is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add the panel to the frame
        frame.setSize(300, 300+22); // set the size of the frame
        frame.setLocationRelativeTo(null); // move to center position
        frame.setVisible(true); // make the frame visible
    }
    
}
