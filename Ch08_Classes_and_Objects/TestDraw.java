package Ch08_Classes_and_Objects;
import javax.swing.JFrame;
/**
 * Fig. 8.20: Creating a JFrame to display a DrawPanel.
 * 
 * @author David
 */
public class TestDraw {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300+22);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
