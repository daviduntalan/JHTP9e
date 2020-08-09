package Ch09_OOP_Inheritance;
import Ch08_Classes_and_Objects.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Fig. 9.1: include a JLabel as a status bar that displays
 * counts representing the number of each shape displayed.
 * @author David
 */
public class Ex09_01_DrawOvalRectangle {
    public static void main(String[] args) {
        DrawOvalPanel panel = new DrawOvalPanel();
        // DrawRectanglePanel panel = new DrawRectanglePanel();
        
        JFrame frame = new JFrame();
        
        // String shapeCounts = String.format("Lines: %d, Ovals: %d, Rectangle: %d", 
        String shapeCounts = String.format("Number of shapes: %d", 
                panel.getNumberOfShapes());
        JLabel shapeCountsLabel = new JLabel(shapeCounts);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300+22);
        frame.add(panel);
        frame.add(shapeCountsLabel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
