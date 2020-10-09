package Ch14_GUI_Components_P1;

import javax.swing.JFrame;

public class TextAreaDemo {

    public static void main(String[] args) {

        TextAreaFrame textAreaFrame = new TextAreaFrame();
        textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAreaFrame.setSize(425, 200); // set frame size
        textAreaFrame.setLocationRelativeTo( null ); // center it
        textAreaFrame.setVisible( true ); // display frame
    }
}
