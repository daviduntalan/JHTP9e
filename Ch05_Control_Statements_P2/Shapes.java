package Ch05_Control_Statements_P2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Demonstrates drawing different shapes.
 * Fig. 5.26
 * @author David
 */
public class Shapes extends JPanel {
    private int choice; // user's choice of which shape to draw

    public Shapes(int choice) {
        this.choice = choice;
    }
    
    @Override // draws a cascade of shapes starting from the top-left corner    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.GREEN);
        for (int i = 0; i < 10; ++i) {
            // pick the shape based ont he user's chocie
            switch (choice) {
                case 1: // draw rectangles
                    g.drawRect(
                            10 + i * 10, // x-cordinate of rectable to be drawn
                            10 + i * 10, // y-cordinate of rectable to be drawn
                            50 + i * 10, // the width of rectable to be drawn
                            50 + i * 10  // the height of rectable to be drawn
                    );
                    break;
                case 2: // draw ovals
                    g.drawOval(
                            10 + i * 10, 
                            10 + i * 10, 
                            50 + i * 10, 
                            50 + i * 10
                    );
                    break;
            }
        }
    }
}
