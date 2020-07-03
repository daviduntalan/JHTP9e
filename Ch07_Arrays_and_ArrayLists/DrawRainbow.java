package Ch07_Arrays_and_ArrayLists;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Fig. 7.25: Demonstrates using colors in an array.
 *
 * @author David
 */
public class DrawRainbow extends JPanel {

    // define indigo and violet
    private final static Color VIOLET = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);

    // colors to use in the rainbow, starting from the innermost
    // The two white entries result in an empty arc in the center
    private Color[] colors = {
        Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
        Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};

    public DrawRainbow() {
        setBackground(Color.WHITE); // set the background to white
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // prepares Graphics to be written as a reference to JPanel
        int radius = 20; // radius of an arc

        // draw the rainbow near the bottom-center
        int centerX = getWidth() / 2;
        int centerY = getHeight() - 10;
        int xPos, yPos, xWidth, yHeight;

        // draws filled arcs starting with the outermost;
        // drawing the largest arcs first and placing each
        // successive smaller arc on top of the previous one.
        for (int counter = colors.length; counter > 0; --counter) {
            // set the color for the current arc
            g.setColor(colors[counter - 1]);

            // fill the arc from 0 to 180 degrees
            xPos = centerX - counter * radius;
            yPos = centerY - counter * radius;
            xWidth  = counter * radius * 2;
            yHeight = counter * radius * 2;            
            // The starting angle and sweep are measured in degrees, with zero 
            // degrees pointing right. A positive sweep draws the arc 
            // counterclockwise, while a negative sweep draws the arc clockwise.
            g.fillArc(xPos, yPos, xWidth, yHeight, 0, 180);            
        } // end for        
    } // end method paintComponent

} // end class DrawRainbow