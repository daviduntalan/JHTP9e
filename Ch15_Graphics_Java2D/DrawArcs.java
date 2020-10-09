package Ch15_Graphics_Java2D;
/** Fig. 15.25: Drawing arcs. */
import javax.swing.JFrame;

public class DrawArcs {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing Arcs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ArcsJPanel()); // add ArcsJPanel to frame
        frame.setSize(300, 210); // set frame size
        frame.setLocationRelativeTo(null); // set frame center
        frame.setVisible(true); // display frame
    }
}
