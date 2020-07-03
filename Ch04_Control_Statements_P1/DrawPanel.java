package Ch04_Control_Statements_P1;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Using drawLine to connect the corners of a panel.
 * Every JPanel, including our DrawPanel, has a paintComponent 
 * method which the system automatically calls every time it needs 
 * to display the JPanel. It must be declared -- otherwise, the 
 * system will not call it. This method is called when a JPanel is 
 * first displayed on the screen, when it's covered then uncovered
 * by a window on the screen and when the window it appears resized. 
 * Fig. 4.18
 * @author David
 */
public class DrawPanel extends JPanel {

    @Override 
    protected void paintComponent(Graphics g) {                
        super.paintComponent(g); 
        // call paintComponent to ensure the panel displays correctly
        // ensures that the panel is properly rendered (displays the result)
        // before we beging dawing on it.

        int width = getWidth(); // total width
        int height = getHeight(); // total height

        // draws an X from the corners of the panel
        g.drawLine(0, 0, width, height); // draw a line from the upper-left to the lower right
        g.drawLine(0, height, width, 0); // draw a line from the lower-left to the upper right
    }
    
}
