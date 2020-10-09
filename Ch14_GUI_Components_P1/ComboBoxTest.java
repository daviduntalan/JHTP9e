package Ch14_GUI_Components_P1;
// Fig. 14.22 Testing ComboBoxFrame
import javax.swing.JFrame;

public class ComboBoxTest {

    public static void main(String[] args) {

        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
        comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBoxFrame.setSize(350, 150); // set frame size
        comboBoxFrame.setLocationRelativeTo( null ); // center frame window
        comboBoxFrame.setVisible( true ); // display frame
    }
}
