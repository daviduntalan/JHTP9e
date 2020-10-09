package Ch14_GUI_Components_P1;
// Fig. 14.32: Testing MouseDetailsFrame.

import javax.swing.*;

public class MouseDetails {

    public static void main(String[] args) {

        MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
        mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseDetailsFrame.setSize(400, 150); // set frame size
        mouseDetailsFrame.setLocationRelativeTo(null); // centered window
        mouseDetailsFrame.setVisible(true); // display frame
    }
}
