package Ch14_GUI_Components_P1;
// Fig. 14.35: Testing PaintPanel.
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class Painter {

    public static void main(String[] args) {

        // create JFrame
        JFrame app = new JFrame("A simple paint program");

        PaintPanel paintPanel = new PaintPanel(); // create paint panel
        app.add( paintPanel, BorderLayout.CENTER ); // in center

        // create label and place it in SOUTH of BorderLayout
        app.add( new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 300);
        app.setLocationRelativeTo( null );
        app.setVisible( true ); // display frame
    }
}
