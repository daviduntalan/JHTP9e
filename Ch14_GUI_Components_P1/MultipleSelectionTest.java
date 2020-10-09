package Ch14_GUI_Components_P1;
// Fig. 14.26 Testing MultipleSelectionFrame
import javax.swing.JFrame;

public class MultipleSelectionTest {

    public static void main(String[] args) {

        MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
        multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        multipleSelectionFrame.setSize(350, 150); // set frame size
        multipleSelectionFrame.setLocationRelativeTo(null); // centered window
        multipleSelectionFrame.setVisible(true);
    }
}
