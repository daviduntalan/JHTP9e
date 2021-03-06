package Ch06_Methods;

import javax.swing.JFrame;

/**
 * Test application that displays a smiley face. Fig. 6.12
 *
 * @author David
 */
public class DrawSmileyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DrawSmiley panel = new DrawSmiley();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(235, 235 + 22);
        frame.setVisible(true);
    }

}
