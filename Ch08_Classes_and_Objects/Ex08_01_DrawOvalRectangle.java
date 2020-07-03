package Ch08_Classes_and_Objects;
import javax.swing.JFrame;
/**
 * Fig. 8.20: Creating a JFrame to display a DrawPanel.
 * @author David
 */
public class Ex08_01_DrawOvalRectangle {
    public static void main(String[] args) {
        DrawOvalPanel panel = new DrawOvalPanel();
        // DrawRectanglePanel panel = new DrawRectanglePanel();
        
        JFrame frame = new JFrame();
        frame.setTitle("Number of Shape: " + panel.getNumberOfShapes());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300+22);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
