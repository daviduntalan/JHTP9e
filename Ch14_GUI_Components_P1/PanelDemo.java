package Ch14_GUI_Components_P1;
// Fig. 14.46: Testing PanelFrame

import javax.swing.JFrame;

public class PanelDemo {

    public static void main(String[] args) {

        PanelFrame panelFrame = new PanelFrame();
        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFrame.setSize(450, 200);
        panelFrame.setLocationRelativeTo(null);
        panelFrame.setVisible(true);
    }
}
