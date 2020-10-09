package Ch14_GUI_Components_P1;
// Fig. 14.24: Selecting colors from a JList.
import javax.swing.JFrame;

public class ListTest {

    public static void main(String[] args) {

        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setSize(350, 150); // set frame size
        listFrame.setLocationRelativeTo( null ); // center frame window
        listFrame.setVisible( true ); // display frame
    }
}
