package Ch14_GUI_Components_P1;

// Fig. 14.16: Testing ButtonFrame

import javax.swing.JFrame;

public class ButtonTest {

    public static void main(String[] args) {

        ButtonFrame buttonFrame = new ButtonFrame(); // create ButtonFrame
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(300, 110); // set frame size
        buttonFrame.setLocationRelativeTo(null); // centered window
        buttonFrame.setVisible(true); // display frame
    }
}
