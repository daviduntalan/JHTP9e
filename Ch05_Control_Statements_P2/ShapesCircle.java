package Ch05_Control_Statements_P2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Demonstrates drawing different shapes.
 * Fig. 5.28
 * @author David
 */
public class ShapesCircle extends JPanel {

    private int radius;

    public ShapesCircle(int radius) {
        this.radius = radius;
    }
    
    @Override // draws a cascade of shapes starting from the top-left corner    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.GREEN);
        
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int halfSize = Math.max(xCenter / radius, yCenter / radius);
        
        for (int i = 0; i < halfSize; ++i) {
            g.drawOval(
                xCenter,
                yCenter,
                i * radius * 2,
                i * radius * 2
            );
            
            xCenter -= radius;
            yCenter -= radius;
        }
    }
}
