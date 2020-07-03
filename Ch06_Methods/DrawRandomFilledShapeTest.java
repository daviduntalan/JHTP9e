package Ch06_Methods;

import javax.swing.JFrame;

/**
 * Test application that displays a smiley face. Fig. 6.12
 *
 * @author David
 */
public class DrawRandomFilledShapeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DrawRandomFilledShape panel = new DrawRandomFilledShape();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400 + 22);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);
    }

}
