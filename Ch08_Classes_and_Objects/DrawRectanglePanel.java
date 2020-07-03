package Ch08_Classes_and_Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
/**
 * Ex08_01: Program that uses class MyLine to draw random oval.
 * @author David
 */
public class DrawRectanglePanel extends JPanel {
    private Random random = new Random();
    private MyRectangle[] rectangles; // array of rectangles        
    
    // constructor, ccreates a panel with random shapes
    public DrawRectanglePanel() {
        setBackground(Color.WHITE);
        rectangles = new MyRectangle[5 + random.nextInt(10)];
        
        // create lines
        for (int count = 0; count < rectangles.length; ++count) {
            // generate random coordinates
            int x = random.nextInt(300) - 100;
            int y = random.nextInt(300) - 100;
            int w = random.nextInt(300) + 100;
            int h = random.nextInt(300) + 100;
            
            // generate a random color
            Color color = new Color( random.nextInt(256), // RGB values
                    random.nextInt(256),  random.nextInt(256));
            
            // add the line to the list of lines to be displayed;
            // so that we can reproduce them each time the system 
            // calls paintComponent.
            rectangles[count] = new MyRectangle(x, y, w, h, color, random.nextBoolean());
        } // end for
    }
    
    @Override // for each shape array, draw the individual shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // draw the lines
        for (MyRectangle rectangle : rectangles) {
            rectangle.draw(g); // we passed Graphics g object 
            // for drawing (lines) on the panel 
        }
    }

    public int getNumberOfShapes() {
        return rectangles.length;
    }
}
