package Ch14_GUI_Components_P1;

// Fig. 14.7: Testing LabelFrame

import javax.swing.JFrame;

public class TextFieldFrameTest {

    public static void main(String[] args) {

        TextFieldFrame textFieldFrame = new TextFieldFrame(); // create TextFieldFrame
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(350, 100); // set frame size
        textFieldFrame.setLocationRelativeTo(null); // centered window
        textFieldFrame.setVisible(true); // display frame
    }
}
