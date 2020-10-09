package Ch14_GUI_Components_P1;
// Fig. 14.42: Testing BorderLayoutFrame
import javax.swing.JFrame;

public class BorderLayoutDemo {

    public static void main(String[] args) {

        BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
        borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayoutFrame.setSize(320, 200);
        borderLayoutFrame.setLocationRelativeTo(null);
        borderLayoutFrame.setVisible(true);
    }
}
