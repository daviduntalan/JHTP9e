package Ch14_GUI_Components_P1;
// Fig. 14.37: Testing KeyDemoFrame.
import javax.swing.JFrame;

public class KeyDemo {

    public static void main(String[] args) {

        KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
        keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyDemoFrame.setSize(350, 100);
        keyDemoFrame.setLocationRelativeTo(null);
        keyDemoFrame.setVisible(true);
    }
}
