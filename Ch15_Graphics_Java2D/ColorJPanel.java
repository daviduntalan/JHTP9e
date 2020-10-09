package Ch15_Graphics_Java2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

/** Fig. 15.5: Demonstrating Colors. */
public class ColorJPanel extends JPanel {

    // draw rectangles and Strings in different color
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent
        setBackground(Color.WHITE);

        // set new drawing color using integers
        g.setColor( new Color(255, 0, 0) );
        g.fillRect(15, 25, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 40);

        // set new drawing color using floats
        g.setColor( new Color(0.50f, 0.75f, 0.0f) ); // 0.50 * 255, 0.75 * 255, 0.0 * 255
        g.fillRect(15, 50, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 65);

        // set new drawing color using static Color object
        g.setColor( Color.BLUE );
        g.fillRect(15, 75, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 90);

        // display individual RGB values
        Color color = Color.MAGENTA;
        g.setColor( color );
        g.fillRect(15, 100, 100, 20);
        String rgbValues = String.format("RGB Values: %d, %d, %d",
                color.getRed(), color.getGreen(), color.getBlue());
        g.drawString(rgbValues, 130, 115 );
    } // end of paintComponent
} // end of class ColorJPanel
