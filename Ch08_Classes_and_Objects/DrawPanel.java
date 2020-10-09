package Ch08_Classes_and_Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
/**
 * Fig. 8.19: Program that uses class MyLine to draw random lines.
 * @author David
 */
public class DrawPanel extends JPanel {
    private Random random = new Random();
    private MyLine[] lines; // array of lines
    
    // constructor, creates a panel with random shapes
    public DrawPanel() {
        setBackground(Color.WHITE);
        lines = new MyLine[5 + random.nextInt(5)];
        
        // create lines
        for (int count = 0; count < lines.length; ++count) {
            // generate random coordinates
            int x1 = random.nextInt(300);
            int y1 = random.nextInt(300);
            int x2 = random.nextInt(300);
            int y2 = random.nextInt(300);
            
            // generate a random color
            Color color = new Color( random.nextInt(256), // RGB values
                    random.nextInt(256),  random.nextInt(256));
            
            // add the line to the list of lines to be displayed;
            // so that we can reproduce them each time the system 
            // calls paintComponent.
            lines[count] = new MyLine(x1, y1, x2, y2, color);
        } // end for
    }
    
    @Override // for each shape array, draw the individual shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // draw the lines
        for (MyLine line : lines) {
            line.draw(g); // we passed g for drawing lines
        }
    }
}
