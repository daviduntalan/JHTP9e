package Ch06_Methods;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Demonstrates filled shapes.
 * Fig. 6.11
 * @author David
 */
public class DrawSmiley extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
                
        // draw the face
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 200);
        
        // draw the eyes
        g.setColor(Color.BLACK);
        g.fillOval(55, 65, 30, 30);
        g.fillOval(135, 65, 30, 30);
        
        // draw the mouth
        g.fillOval(50, 110, 120, 60);
        
        g.setColor(Color.YELLOW);
        // g.setColor(Color.BLUE);
        g.fillRect(50, 110, 120, 30);
        // g.setColor(Color.GREEN);
        // g.fillOval(50, 120, 120, 40);
    }    
    
}
