package Ch06_Methods;

import javax.swing.JFrame;

/**
 * Test application that displays a smiley face. Fig. 6.12
 *
 * @author David
 */
public class DrawBullsEyeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DrawBullsEye panel = new DrawBullsEye();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(235, 235 + 22);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);
    }

}
