package Ch14_GUI_Components_P1;
// Fig. 14.40: Testing FlowLayoutFrame
import javax.swing.JFrame;

public class FlowLayoutDemo {

    public static void main(String[] args) {

        FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
        flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowLayoutFrame.setSize(300, 75);
        flowLayoutFrame.setLocationRelativeTo(null);
        flowLayoutFrame.setVisible(true);
    }
}
